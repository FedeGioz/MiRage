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
 * @param on 
 * @param port 
 * @param timeout 
 */
@Serializable@Serializable

data class PutIoModuleStatus (

    @SerialName(value = "on") val on: kotlin.Boolean? = null,

    @SerialName(value = "port") val port: kotlin.Long? = null,

    @SerialName(value = "timeout") val timeout: kotlin.Long? = null

)

