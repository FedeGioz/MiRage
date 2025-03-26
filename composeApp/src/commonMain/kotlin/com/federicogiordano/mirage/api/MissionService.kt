package com.federicogiordano.mirage.api

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class MissionService : BaseApiService {
    suspend fun getMissions(): List<Mission> {
        return client.get(ApiClient.getEndpoint("missions")).body()
    }

    suspend fun createMission(mission: Mission) {
        client.post(ApiClient.getEndpoint("missions")) {
            contentType(ContentType.Application.Json)
            setBody(mission)
        }
    }
}

data class Mission(
    val id: String? = null,
    val name: String,
    val mapId: String,
    val waypoints: List<Waypoint>
)

data class Waypoint(
    val x: Float,
    val y: Float,
    val action: String? = null
)