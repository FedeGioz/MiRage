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
 * @param orientation The orientation of the current position of the robot
 * @param x The x-coordinate of the current position of the robot
 * @param y The y-coordinate of the current position of the robot
 */
@Serializable@Serializable

data class Position (

    /* The orientation of the current position of the robot */
    @SerialName(value = "orientation") val orientation: kotlin.Float? = null,

    /* The x-coordinate of the current position of the robot */
    @SerialName(value = "x") val x: kotlin.Float? = null,

    /* The y-coordinate of the current position of the robot */
    @SerialName(value = "y") val y: kotlin.Float? = null

)

