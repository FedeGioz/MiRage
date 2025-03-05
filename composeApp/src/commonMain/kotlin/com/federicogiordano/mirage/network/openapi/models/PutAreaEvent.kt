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
 * @param actions 
 * @param mapId 
 * @param name Max length: 255
 * @param polygon 
 * @param typeId 
 */
@Serializable@Serializable

data class PutAreaEvent (

    @SerialName(value = "actions") val actions: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "map_id") val mapId: kotlin.String? = null,

    /* Max length: 255 */
    @SerialName(value = "name") val name: kotlin.String? = null,

    @SerialName(value = "polygon") val polygon: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "type_id") val typeId: kotlin.Long? = null

)

