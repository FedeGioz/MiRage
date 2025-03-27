package com.federicogiordano.mirage.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.federicogiordano.mirage.data.RobotStatus

@Composable
fun StatusIndicator(status: RobotStatus?) {
    status?.let {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 8.dp)
        ) {
            it.stateText.let { state ->
                Text(
                    text = state,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            it.batteryPercentage.let { battery ->
                val batteryIcon = when {
                    battery > 75 -> Icons.Default.BatteryFull
                    battery > 45 -> Icons.Default.Battery3Bar
                    battery > 15 -> Icons.Default.Battery2Bar
                    else -> Icons.Default.BatteryAlert
                }

                Icon(
                    imageVector = batteryIcon,
                    contentDescription = "Battery: ${battery.toInt()}%",
                    tint = if (battery > 20) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.error
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${battery.toInt()}%",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.width(4.dp))
            }

            it.batteryTimeRemaining.let { batteryTime ->
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${batteryTime/3600}:${(batteryTime%3600)/60} hours",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    } ?: Text("Connecting...", style = MaterialTheme.typography.bodySmall)
}