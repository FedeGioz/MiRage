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
 * @param endpoint 
 * @param guid The global unique id across robots that identifies this permission
 * @param permissionType The permission type
 * @param url The URL of the resource
 */
@Serializable@Serializable

data class GetUserMePermissions (

    @SerialName(value = "endpoint") val endpoint: kotlin.String? = null,

    /* The global unique id across robots that identifies this permission */
    @SerialName(value = "guid") val guid: kotlin.String? = null,

    /* The permission type */
    @SerialName(value = "permission_type") val permissionType: kotlin.String? = null,

    /* The URL of the resource */
    @SerialName(value = "url") val url: kotlin.String? = null

)

