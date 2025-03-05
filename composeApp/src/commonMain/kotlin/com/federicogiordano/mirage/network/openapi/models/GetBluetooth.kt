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
 * @param address The mac address of the blueooth device
 * @param name The name of the bluetooth device
 * @param url The URL of the resource
 */
@Serializable@Serializable

data class GetBluetooth (

    /* The mac address of the blueooth device */
    @SerialName(value = "address") val address: kotlin.String? = null,

    /* The name of the bluetooth device */
    @SerialName(value = "name") val name: kotlin.String? = null,

    /* The URL of the resource */
    @SerialName(value = "url") val url: kotlin.String? = null

)

