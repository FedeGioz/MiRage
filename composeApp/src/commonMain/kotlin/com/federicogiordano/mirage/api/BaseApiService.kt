package com.federicogiordano.mirage.api

import io.ktor.client.*

interface BaseApiService {
    val client: HttpClient
        get() = ApiClient.httpClient
}