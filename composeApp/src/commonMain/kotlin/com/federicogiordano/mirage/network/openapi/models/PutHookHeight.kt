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
 * @param height 
 * @param home 
 */
@Serializable@Serializable

data class PutHookHeight (

    @SerialName(value = "height") val height: kotlin.Long? = null,

    @SerialName(value = "home") val home: kotlin.Boolean? = null

)

