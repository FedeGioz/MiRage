package com.federicogiordano.mirage

import io.ktor.client.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class RobotWebSocketClient(
    private val serverUrl: String = "ws://192.168.12.20:9090/"
) {
    private val client = HttpClient {
        install(WebSockets)
        install(Logging) {
            level = LogLevel.INFO
        }
    }

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var session: DefaultWebSocketSession? = null
    private var joystickToken: String? = null
    private var messageCount = 0

    @Serializable
    data class RobotStateRequest(
        val op: String = "call_service",
        val id: String = "call_service:/mirsupervisor/setRobotState:7",
        val service: String = "/mirsupervisor/setRobotState",
        val args: RobotStateArgs
    )

    @Serializable
    data class RobotStateArgs(
        val robotState: Int = 11,
        val web_session_id: String = "4nn6sbubuetsmujl3ae96f9140"
    )

    @Serializable
    data class VelocityCommand(
        val op: String = "publish",
        val id: String,
        val topic: String = "/joystick_vel",
        val msg: VelocityMessage,
        val latch: Boolean = false
    )

    @Serializable
    data class VelocityMessage(
        val joystick_token: String,
        val speed_command: SpeedCommand
    )

    @Serializable
    data class SpeedCommand(
        val linear: Vector3,
        val angular: Vector3
    )

    @Serializable
    data class Vector3(
        val x: Float = 0f,
        val y: Float = 0f,
        val z: Float = 0f
    )

    fun connect() {
        println("STARTED CONNECT")
        scope.launch {
            try {
                client.webSocket(serverUrl) {
                    session = this
                    println("WEBSOCKET DEF CONNECTED") // Arriva fin qua

                    launch {
                        for (frame in incoming) {
                            when (frame) {
                                is Frame.Text -> {
                                    val text = frame.readText()
                                    println("Received message: $text")
                                    processMessage(text)
                                }
                                else -> {}
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                println("WebSocket error: ${e.message}")
            }
        }
    }

    private fun processMessage(message: String) {
        try {
            val jsonElement = Json.parseToJsonElement(message)
            val jsonObject = jsonElement.jsonObject

            if (jsonObject.containsKey("values") &&
                jsonObject["values"]?.jsonObject?.containsKey("joystick_token") == true) {
                joystickToken = jsonObject["values"]?.jsonObject?.get("joystick_token")?.jsonPrimitive?.content
                println("Received joystick token: $joystickToken")
            }
        } catch (e: Exception) {
            println("Error processing message: ${e.message}")
        }
    }

    private val json = Json {
        encodeDefaults = true
    }

    fun requestManualControl() {
        scope.launch {
            val request = RobotStateRequest(
                args = RobotStateArgs(
                    robotState = 11,
                    web_session_id = "4nn6sbubuetsmujl3ae96f9140"
                )
            )

            println("REQUEST MANUAL: " + json.encodeToString(request))
            sendMessage(json.encodeToString(request))
        }
    }

    fun sendVelocity(linear: Float, angular: Float) {
        if (joystickToken == null) return

        scope.launch {
            messageCount++
            val velocityCommand = VelocityCommand(
                id = "publish:/joystick_vel:$messageCount",
                msg = VelocityMessage(
                    joystick_token = joystickToken!!,
                    speed_command = SpeedCommand(
                        linear = Vector3(x = linear),
                        angular = Vector3(z = angular)
                    )
                )
            )
            sendMessage(Json.encodeToString(velocityCommand))
        }
    }

    private suspend fun sendMessage(message: String) {
        session?.send(Frame.Text(message))
    }

    fun disconnect() {
        scope.launch {
            session?.close()
            client.close()
        }
    }
}