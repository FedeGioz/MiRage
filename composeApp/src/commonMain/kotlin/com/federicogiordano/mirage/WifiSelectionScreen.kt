package com.federicogiordano.mirage // Corrected package

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.federicogiordano.mirage.MRGTheme // Added import for MRGTheme
import com.federicogiordano.mirage.viewmodel.WifiViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

// Define a simple factory for WifiViewModel if you don't have a more complex DI setup
fun createWifiViewModel() = WifiViewModel()

@Composable
fun WifiSelectionScreen(
    onNavigateToLogin: () -> Unit
) {
    val viewModel: WifiViewModel = getViewModel(Unit, viewModelFactory { createWifiViewModel() })
    val uiState by viewModel.uiState.collectAsState()

    MRGTheme { // Assuming MRGTheme is in com.federicogiordano.mirage package or correctly imported
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Checking WiFi status...")
                } else {
                    Text(
                        text = "WiFi Connection",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (uiState.isWifiConnected) {
                        Text("Connected to: ${uiState.currentSsid ?: "WiFi Network"}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "If this is the robot's WiFi, you can proceed to login.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    } else {
                        Text("Not connected to any WiFi network.")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Please connect to the robot's WiFi network to continue.",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = { viewModel.openWifiSettings() }) {
                        Text("Open WiFi Settings")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onNavigateToLogin,
                        enabled = uiState.isWifiConnected // Enable if connected to any WiFi
                        // For a specific robot SSID, you would check:
                        // enabled = uiState.currentSsid == "YourRobotSSID"
                    ) {
                        Text("Proceed to Login")
                    }
                }
            }
        }
    }
}
