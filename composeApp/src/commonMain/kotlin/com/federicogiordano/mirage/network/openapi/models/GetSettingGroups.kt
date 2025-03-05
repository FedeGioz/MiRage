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
 * @param id 
 * @param name 
 * @param url The URL of the resource
 */
@Serializable@Serializable

data class GetSettingGroups (

    @SerialName(value = "id") val id: kotlin.Long? = null,

    @SerialName(value = "name") val name: kotlin.String? = null,

    /* The URL of the resource */
    @SerialName(value = "url") val url: kotlin.String? = null

)

