/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.federicogiordano.mirage.models


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param goalPosId 
 * @param missionId 
 * @param startPosId 
 */
@Serializable@Serializable

data class PutPositionTransitionList (

    @SerialName(value = "goal_pos_id") val goalPosId: kotlin.String? = null,

    @SerialName(value = "mission_id") val missionId: kotlin.String? = null,

    @SerialName(value = "start_pos_id") val startPosId: kotlin.String? = null

)

