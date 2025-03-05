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
 * @param answer Min length: 1, Max length: 255
 * @param clearError 
 * @param datetime 
 * @param guid 
 * @param mapId 
 * @param modeId Choices are: {3, 7}
 * @param name Min length: 1, Max length: 20
 * @param position 
 * @param serialNumber 
 * @param stateId Choices are: {3, 4, 11}, State: {Ready, Pause, Manualcontrol}
 * @param webSessionId 
 */
@Serializable@Serializable

data class PutStatus (

    /* Min length: 1, Max length: 255 */
    @SerialName(value = "answer") val answer: kotlin.String? = null,

    @SerialName(value = "clear_error") val clearError: kotlin.Boolean? = null,

    @SerialName(value = "datetime") val datetime: kotlin.String? = null,

    @SerialName(value = "guid") val guid: kotlin.String? = null,

    @SerialName(value = "map_id") val mapId: kotlin.String? = null,

    /* Choices are: {3, 7} */
    @SerialName(value = "mode_id") val modeId: kotlin.Long? = null,

    /* Min length: 1, Max length: 20 */
    @SerialName(value = "name") val name: kotlin.String? = null,

    @SerialName(value = "position") val position: kotlin.String? = null,

    @SerialName(value = "serial_number") val serialNumber: kotlin.String? = null,

    /* Choices are: {3, 4, 11}, State: {Ready, Pause, Manualcontrol} */
    @SerialName(value = "state_id") val stateId: kotlin.Long? = null,

    @SerialName(value = "web_session_id") val webSessionId: kotlin.String? = null

)

