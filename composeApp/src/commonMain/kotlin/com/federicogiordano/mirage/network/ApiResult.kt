package com.federicogiordano.mirage.network

import com.federicogiordano.mirage.network.openapi.infrastructure.ApiClient


sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val message: String, val code: Int? = null) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}