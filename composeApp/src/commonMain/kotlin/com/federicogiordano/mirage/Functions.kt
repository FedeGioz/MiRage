package com.federicogiordano.mirage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class FunctionMenuItem(
    val id: String,
    val title: String,
    val description: String
)

val functionMenuItems = listOf(
    FunctionMenuItem("sounds", "Sounds", "View and play sounds"),
    FunctionMenuItem("mapping", "Mapping", "Create and manage maps"),
    FunctionMenuItem("missions", "Missions", "Create and execute missions"),
    FunctionMenuItem("diagnostics", "Diagnostics", "System diagnostics and troubleshooting")
)

@Composable
fun Functions(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(functionMenuItems) { item ->
            FunctionMenuCard(item) {
                navController.navigate("function/${item.id}")
            }
        }
    }
}

@Composable
fun FunctionMenuCard(item: FunctionMenuItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Go to ${item.title}",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun FunctionSubScreen(
    title: String,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$title submenu",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}