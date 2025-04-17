package com.federicogiordano.mirage.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object ApiClient {
    private const val API_URL = "http://192.168.12.20/api/v2.0.0"
//    private const val API_URL = "http://192.168.126.223:8080/api/v2.0.0"

    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }

        engine {
            requestTimeout = 60_000
            endpoint {
                connectTimeout = 60_000
                socketTimeout = 60_000
            }
        }

        defaultRequest {
            url(API_URL)
            header("Authorization", "Basic aXRpc2RlbHBvenpvOjlhZDVhYjA0NDVkZTE4ZDI4Nzg0NjMzNzNkNmRiZGIxZWUzZTFmZjg2YzBhYmY4OGJiMzU5YzNkYzVmMzBiNGQ=")
            header("Accept-Language", "en_US")
        }
    }

    fun getEndpoint(path: String): String {
        val cleanPath = if (path.startsWith("/")) path.substring(1) else path
        return "$API_URL/$cleanPath"
    }
}