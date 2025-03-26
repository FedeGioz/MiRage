package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.RobotMap
import io.ktor.client.call.*
import io.ktor.client.request.*

class MappingService : BaseApiService {
    suspend fun getMaps(): List<RobotMap> {
        return client.get(ApiClient.getEndpoint("maps")).body()
    }

    suspend fun getMapById(id: String): RobotMap {
        return client.get(ApiClient.getEndpoint("maps/$id")).body()
    }

    // Fare anche delete? Se applicazione di base per gente che non ne sa nulla forse rischioso
}

data class Map(
    val id: String,
    val name: String,
    val createdAt: String
)