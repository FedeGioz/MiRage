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
 * @param createdBy The url to the description of the type of this position
 * @param createdById The global id of the user who created this entry
 * @param guid The global id unique across robots that identifies this sound
 * @param length The length of the sound in the format hh:mm:ss
 * @param name The name of the sound
 * @param note A possible description of the sound
 * @param sound A binary representation of the sound
 * @param stream The url to stream the raw audio
 * @param volume The volumne of the sound when played
 */
@Serializable@Serializable

data class GetSound (

    /* The url to the description of the type of this position */
    @SerialName(value = "created_by") val createdBy: kotlin.String? = null,

    /* The global id of the user who created this entry */
    @SerialName(value = "created_by_id") val createdById: kotlin.String? = null,

    /* The global id unique across robots that identifies this sound */
    @SerialName(value = "guid") val guid: kotlin.String? = null,

    /* The length of the sound in the format hh:mm:ss */
    @SerialName(value = "length") val length: kotlin.String? = null,

    /* The name of the sound */
    @SerialName(value = "name") val name: kotlin.String? = null,

    /* A possible description of the sound */
    @SerialName(value = "note") val note: kotlin.String? = null,

    /* A binary representation of the sound */
    @SerialName(value = "sound") val sound: com.federicogiordano.mirage.infrastructure.Base64ByteArray? = null,

    /* The url to stream the raw audio */
    @SerialName(value = "stream") val stream: kotlin.String? = null,

    /* The volumne of the sound when played */
    @SerialName(value = "volume") val volume: kotlin.Long? = null

)

