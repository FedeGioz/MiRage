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
 * @param username Min length: 2, Max length: 63
 */
@Serializable@Serializable

data class PutUserGroup (

    /* Min length: 2, Max length: 63 */
    @SerialName(value = "username") val username: kotlin.String? = null

)

