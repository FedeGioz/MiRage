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
 * @param errorMessage A description of this action
 * @param missionsToImport 
 * @param sessionsImported The type of area action
 * @param sessionsTotal A name associated with this area action
 * @param status A nice name associated with this area action
 */
@Serializable@Serializable

data class GetSessionImport (

    /* A description of this action */
    @SerialName(value = "error_message") val errorMessage: kotlin.String? = null,

    @SerialName(value = "missions_to_import") val missionsToImport: kotlin.String? = null,

    /* The type of area action */
    @SerialName(value = "sessions_imported") val sessionsImported: kotlin.Long? = null,

    /* A name associated with this area action */
    @SerialName(value = "sessions_total") val sessionsTotal: kotlin.Long? = null,

    /* A nice name associated with this area action */
    @SerialName(value = "status") val status: kotlin.Long? = null

)

