package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.RobotMission
import com.federicogiordano.mirage.data.RobotSound
import io.ktor.client.call.body
import io.ktor.client.request.get

class SoundsService : BaseApiService {
    suspend fun getSounds(): List<RobotSound> {
        return client.get(ApiClient.getEndpoint("sounds")).body()
    }
}