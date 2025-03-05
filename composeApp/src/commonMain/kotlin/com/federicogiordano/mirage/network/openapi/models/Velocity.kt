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
 * @param angular The angular speed of the robot in degrees/s
 * @param linear The linear speed of the robot in m/s
 */
@Serializable@Serializable

data class Velocity (

    /* The angular speed of the robot in degrees/s */
    @SerialName(value = "angular") val angular: kotlin.Float? = null,

    /* The linear speed of the robot in m/s */
    @SerialName(value = "linear") val linear: kotlin.Float? = null

)

