package com.federicogiordano.mirage.data

import kotlinx.serialization.Serializable

@Serializable
data class VelocityData(
    val angular : Float? = null,
    val linear : Float? = null
)