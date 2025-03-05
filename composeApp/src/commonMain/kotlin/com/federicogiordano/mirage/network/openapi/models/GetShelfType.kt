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
 * @param barDistance The distance between the side bars of shelves of this type
 * @param barLength The length of the side bars of shelves of this type
 * @param createdBy The url to the description of the type of this position
 * @param createdById The global id of the user who created this entry
 * @param guid The global id unique across robots that identifies this shelf type
 * @param height The height of shelves of this type
 * @param length The length of shelves of this type
 * @param name The name of the shelf type
 * @param offsetX The offset in the x-coordinate of shelf of this type
 * @param offsetY The offset in the y-coordinate of shelves of this type
 * @param width The width of shelves of this type
 */
@Serializable@Serializable

data class GetShelfType (

    /* The distance between the side bars of shelves of this type */
    @SerialName(value = "bar_distance") val barDistance: kotlin.Float? = null,

    /* The length of the side bars of shelves of this type */
    @SerialName(value = "bar_length") val barLength: kotlin.Float? = null,

    /* The url to the description of the type of this position */
    @SerialName(value = "created_by") val createdBy: kotlin.String? = null,

    /* The global id of the user who created this entry */
    @SerialName(value = "created_by_id") val createdById: kotlin.String? = null,

    /* The global id unique across robots that identifies this shelf type */
    @SerialName(value = "guid") val guid: kotlin.String? = null,

    /* The height of shelves of this type */
    @SerialName(value = "height") val height: kotlin.Float? = null,

    /* The length of shelves of this type */
    @SerialName(value = "length") val length: kotlin.Float? = null,

    /* The name of the shelf type */
    @SerialName(value = "name") val name: kotlin.String? = null,

    /* The offset in the x-coordinate of shelf of this type */
    @SerialName(value = "offset_x") val offsetX: kotlin.Float? = null,

    /* The offset in the y-coordinate of shelves of this type */
    @SerialName(value = "offset_y") val offsetY: kotlin.Float? = null,

    /* The width of shelves of this type */
    @SerialName(value = "width") val width: kotlin.Float? = null

)

