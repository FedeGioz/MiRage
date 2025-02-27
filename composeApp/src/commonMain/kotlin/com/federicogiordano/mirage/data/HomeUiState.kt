package com.federicogiordano.mirage.data

data class HomeUiState(
    val batteryPercentage : Float? = null,
    val batteryTime : Int? = null,
    val errors : List<String>? = null,
    val mapId : String? = null,
    val missionQueueId : Int? = null,
    val missionText : String? = null,
    val modeId : Int? = null,
    val modeText : String? = null,
    val moved : Float? = null,
    val position : PositionData? = null,
    val stateText : String? = null,
    val velocity: VelocityData? = null,
)