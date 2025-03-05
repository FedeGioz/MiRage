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
 * @param description 
 * @param downloadUrl The url to where the bag can be downloaded
 * @param id Id of the autobag
 * @param module The module that created the autolog
 * @param ready Status of the rosbag
 * @param time The time where the autolog was created
 */
@Serializable@Serializable

data class GetErrorReport (

    @SerialName(value = "description") val description: kotlin.String? = null,

    /* The url to where the bag can be downloaded */
    @SerialName(value = "download_url") val downloadUrl: kotlin.String? = null,

    /* Id of the autobag */
    @SerialName(value = "id") val id: kotlin.Long? = null,

    /* The module that created the autolog */
    @SerialName(value = "module") val module: kotlin.String? = null,

    /* Status of the rosbag */
    @SerialName(value = "ready") val ready: kotlin.Boolean? = null,

    /* The time where the autolog was created */
    @SerialName(value = "time") val time: kotlin.String? = null

)

