package com.federicogiordano.mirage.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RobotMission(
    @SerialName("name") val name: String = "",
    @SerialName("guid") val guid: String = ""
)