package com.federicogiordano.mirage.network

import com.federicogiordano.mirage.data.PositionData
import com.federicogiordano.mirage.data.VelocityData
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class RobotStatus(
    val batteryPercentage: Float? = null,
    val batteryTime: Int? = null,
    val errors: List<String>? = null,
    val mapId: String? = null,
    val missionQueueId: Int? = null,
    val missionText: String? = null,
    val modeId: Int? = null,
    val modeText: String? = null,
    val moved: Float? = null,
    val position: PositionData? = null,
    val stateText: String? = null,
    val velocity: VelocityData? = null
)


class RobotStatusService(private val baseUrl: String) : BaseApiService() {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    suspend fun getRobotStatus(): ApiResult<RobotStatus> {
        return safeApiCall {
            client.get("$baseUrl/api/robot/status").body()
        }
    }

    suspend fun setDeviceCommand(command: String): ApiResult<Boolean> {
        return safeApiCall {
            val response = client.post("$baseUrl/api/robot/command") {
                contentType(ContentType.Application.Json)
                setBody(mapOf("command" to command))
            }
            response.status.isSuccess()
        }
    }
}