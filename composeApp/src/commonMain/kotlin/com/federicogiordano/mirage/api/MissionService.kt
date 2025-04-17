package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.RobotMission
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class MissionService : BaseApiService {
    suspend fun getMissions(): List<RobotMission> {
        return client.get(ApiClient.getEndpoint("missions")).body()
    }

    suspend fun createMission(mission: RobotMission) {
        client.post(ApiClient.getEndpoint("missions")) {
            contentType(ContentType.Application.Json)
            setBody(mission)
        }
    }

    suspend fun addMissionToQueue(mission: RobotMission) {
        client.post(ApiClient.getEndpoint("mission_queue")) {
            contentType(ContentType.Application.Json)
            setBody(mapOf("mission_id" to mission.guid))
        }
    }
}