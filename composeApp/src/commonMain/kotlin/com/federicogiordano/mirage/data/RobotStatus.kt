package com.federicogiordano.mirage.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RobotStatus(
    @SerialName("mode_id") val modeId: Int = -1,
    @SerialName("mission_queue_id") val missionQueueId: String? = null,
    @SerialName("robot_name") val robotName: String = "",
    @SerialName("uptime") val uptime: Long = -1,
    @SerialName("errors") val errors: List<String> = emptyList(),
    @SerialName("battery_percentage") val batteryPercentage: Float = 0f,
    @SerialName("map_id") val mapId: String = "",
    @SerialName("mission_text") val missionText: String = "",
    @SerialName("state_text") val stateText: String = "",
    @SerialName("velocity") val velocity: Velocity = Velocity(),
    @SerialName("robot_model") val robotModel: String = "",
    @SerialName("mode_text") val modeText: String = "",
    @SerialName("battery_time_remaining") val batteryTimeRemaining: Long = -1,
    @SerialName("position") val position: Position = Position()
)

@Serializable
data class Velocity(
    val linear: Float? = null,
    val angular: Float? = null
)

@Serializable
data class Position(
    val x: Float? = null,
    val y: Float? = null,
    val orientation: Float? = null
)