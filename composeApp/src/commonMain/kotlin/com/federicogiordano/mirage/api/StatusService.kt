package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.RobotStatus
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay

class StatusService : BaseApiService {
    suspend fun getStatus(): RobotStatus {
        return try {
            client.get(ApiClient.getEndpoint("status")).body()
        } catch (e: Exception) {
            RobotStatus()
        }
    }

    fun statusFlow(intervalSeconds: Long = 10): Flow<RobotStatus> = flow {
        while (true) {
            try {
                emit(getStatus())
            } catch (e: Exception) {
                emit(RobotStatus(batteryPercentage = 50f, stateText = "Connection Error"))
            }
            delay(intervalSeconds * 1000)
        }
    }
}