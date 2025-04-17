package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.RobotMap
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess

class MappingService : BaseApiService {
    suspend fun getMaps(): List<RobotMap> {
        return client.get(ApiClient.getEndpoint("maps")).body()
    }

    suspend fun updateMap(mapId: String): Boolean {
        return try {
            val response = client.put(ApiClient.getEndpoint("status")) {
                contentType(ContentType.Application.Json)
                setBody(mapOf("map_id" to mapId))
            }
            response.status.isSuccess()
        } catch (e: Exception) {
            false
        }
    }

    // Fare anche delete? Se applicazione di base per gente che non ne sa nulla forse rischioso
}

data class Map(
    val id: String,
    val name: String,
    val createdAt: String
)