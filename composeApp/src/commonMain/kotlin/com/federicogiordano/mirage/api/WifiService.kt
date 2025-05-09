package com.federicogiordano.mirage.api

import com.federicogiordano.mirage.data.WifiConnectionDetails
import com.federicogiordano.mirage.data.WifiConnectionRequest
import com.federicogiordano.mirage.data.WifiNetworkInfo
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess


class WifiService : BaseApiService {

    /**
     * Retrieves the list of available WiFi networks.
     * Corresponds to GET /wifi/networks
     */
    suspend fun getAvailableNetworks(): List<WifiNetworkInfo> {
        return try {
            client.get(ApiClient.getEndpoint("wifi/networks")).body()
        } catch (e: Exception) {
            println("Error fetching available networks: ${e.message}")
            emptyList()
        }
    }

    /**
     * Retrieves the list of currently configured/connected WiFi networks.
     * Corresponds to GET /wifi/connections
     */
    suspend fun getCurrentConnections(): List<WifiConnectionDetails> {
        return try {
            client.get(ApiClient.getEndpoint("wifi/connections")).body()
        } catch (e: Exception) {
            println("Error fetching current connections: ${e.message}")
            emptyList()
        }
    }

    /**
     * Connects to a WiFi network specified by its UUID.
     * Corresponds to POST /wifi/connections/{uuid}
     * @param networkUuid The UUID of the network to connect to (obtained from scan results).
     * @param connectionRequest Details for the connection, like SSID and security parameters.
     * @return WifiConnectionDetails if successful, null otherwise.
     */
    suspend fun connectToNetwork(networkUuid: String, connectionRequest: WifiConnectionRequest): WifiConnectionDetails? {
        return try {
            val response: HttpResponse = client.post(ApiClient.getEndpoint("wifi/connections/$networkUuid")) {
                contentType(ContentType.Application.Json)
                setBody(connectionRequest)
            }
            if (response.status.isSuccess()) {
                response.body()
            } else {
                println("Error connecting to network $networkUuid: ${response.status}")
                null
            }
        } catch (e: Exception) {
            println("Error connecting to network $networkUuid: ${e.message}")
            null
        }
    }

    /**
     * Disconnects from a WiFi network specified by its connection UUID.
     * Corresponds to DELETE /wifi/connections/{uuid}
     * @param connectionUuid The UUID of the connection to terminate.
     * @return True if disconnection was successful, false otherwise.
     */
    suspend fun disconnectNetwork(connectionUuid: String): Boolean {
        return try {
            val response: HttpResponse = client.delete(ApiClient.getEndpoint("wifi/connections/$connectionUuid"))
            response.status.isSuccess()
        } catch (e: Exception) {
            println("Error disconnecting from network $connectionUuid: ${e.message}")
            false
        }
    }
}
