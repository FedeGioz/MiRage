package com.federicogiordano.mirage.data

import kotlinx.serialization.Serializable

@Serializable
data class PositionData (
    val orientation : Float? = null,
    val x : Float? = null,
    val y : Float? = null
)