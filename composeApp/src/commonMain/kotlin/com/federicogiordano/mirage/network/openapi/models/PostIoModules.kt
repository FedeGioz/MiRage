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
 * @param address 
 * @param name Min length: 1, Max length: 255
 * @param createdById 
 * @param guid 
 * @param numInputs 
 * @param numOutputs 
 * @param type 
 */
@Serializable@Serializable

data class PostIoModules (

    @SerialName(value = "address") @Required val address: kotlin.String,

    /* Min length: 1, Max length: 255 */
    @SerialName(value = "name") @Required val name: kotlin.String,

    @SerialName(value = "created_by_id") val createdById: kotlin.String? = null,

    @SerialName(value = "guid") val guid: kotlin.String? = null,

    @SerialName(value = "num_inputs") val numInputs: kotlin.Long? = null,

    @SerialName(value = "num_outputs") val numOutputs: kotlin.Long? = null,

    @SerialName(value = "type") val type: kotlin.String? = null

)

