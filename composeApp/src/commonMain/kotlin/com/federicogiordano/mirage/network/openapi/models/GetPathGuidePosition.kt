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
 * @param guid The global unique id across robots of the position in the list of path constraints positions
 * @param pathGuideGuid The global unique id across robots of the path guide this position is related to
 * @param posGuid The global unique id across robots that identifies this position
 * @param posType The type of position of the guide (start/via/goal)
 * @param priority The order in which to follow the via positions in the path guide
 */
@Serializable@Serializable

data class GetPathGuidePosition (

    /* The global unique id across robots of the position in the list of path constraints positions */
    @SerialName(value = "guid") val guid: kotlin.String? = null,

    /* The global unique id across robots of the path guide this position is related to */
    @SerialName(value = "path_guide_guid") val pathGuideGuid: kotlin.String? = null,

    /* The global unique id across robots that identifies this position */
    @SerialName(value = "pos_guid") val posGuid: kotlin.String? = null,

    /* The type of position of the guide (start/via/goal) */
    @SerialName(value = "pos_type") val posType: kotlin.String? = null,

    /* The order in which to follow the via positions in the path guide */
    @SerialName(value = "priority") val priority: kotlin.Long? = null

)

