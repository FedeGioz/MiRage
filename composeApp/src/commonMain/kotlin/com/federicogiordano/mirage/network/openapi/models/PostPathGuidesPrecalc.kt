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
 * @param command 
 * @param guid 
 */
@Serializable@Serializable

data class PostPathGuidesPrecalc (

    @SerialName(value = "command") @Required val command: kotlin.String,

    @SerialName(value = "guid") @Required val guid: kotlin.String

)

