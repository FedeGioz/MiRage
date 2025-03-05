package com.federicogiordano.mirage.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseApiService {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ApiResult<T> {
        return try {
            val response: T = withContext(Dispatchers.Default) {
                apiCall()
            }
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(e.message ?: "Unknown error occurred")
        }
    }
}