package com.federicogiordano.mirage.data

import kotlinx.serialization.Serializable

/**
 * Represents a scanned WiFi network available for connection.
 * Based on GET /wifi/networks endpoint (GetWifi_network schema).
 */
@Serializable
data class WifiNetworkInfo(
    val guid: String, // UUID of the network, used to initiate connection
    val ssid: String,
    val strength: Int,
    val security: String? = null, // e.g., "WPA2-PSK", "WEP", "OPEN"
    val connected: Boolean, // Indicates if the robot is currently connected to this network
    val channel: Int? = null,
    val frequency: String? = null,
    val device: String? = null
)

/**
 * Represents details of a configured or currently active WiFi connection.
 * Based on GET /wifi/connections endpoint (GetWifi_connections schema)
 * and response of POST /wifi/connections/{uuid} (GetWifi_connection schema).
 */
@Serializable
data class WifiConnectionDetails(
    val uuid: String, // UUID of the configured/active connection
    val ssid: String?, // Name of the network
    val bssid: String? = null,
    val connected: Boolean,
    val mac: String? = null,
    val ipAddress: String? = null, // From GetWifi_connection.ip_address
    val security: String? = null, // From GetWifi_connection.security
    val device: String? = null, // From GetWifi_connection.device
    val url: String? = null
)

/**
 * Request body for connecting to a WiFi network.
 * Based on POST /wifi/connections/{uuid} (PostWifi_connection schema).
 * The 'uuid' of the network to connect to is passed in the URL path.
 */
@Serializable
data class WifiConnectionRequest(
    val ssid: String, // SSID of the network to connect to (required in PostWifi_connection)
    val security: String? = null, // Security configuration string (e.g., for WPA2-PSK, might include password or be just type)
    // Add other optional fields from PostWifi_connection as needed:
    // val address: String? = null,
    // val description: String? = null,
    // val device: String? = null,
    // etc.
)
