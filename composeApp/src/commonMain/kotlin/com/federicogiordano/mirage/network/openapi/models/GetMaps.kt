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
 * @param guid The global id unique across robots that identifies this map
 * @param name The name of the map
 * @param url The URL of the resource
 */
@Serializable@Serializable

data class GetMaps (

    /* The global id unique across robots that identifies this map */
    @SerialName(value = "guid") val guid: kotlin.String? = null,

    /* The name of the map */
    @SerialName(value = "name") val name: kotlin.String? = null,

    /* The URL of the resource */
    @SerialName(value = "url") val url: kotlin.String? = null

)

