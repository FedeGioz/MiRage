package com.federicogiordano.mirage.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.Brightness1
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.federicogiordano.mirage.Screens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    navController: NavHostController,
    currentScreen: Screens,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                actions = {
                    IconButton(onClick = {}){
                        Icon(Icons.Default.BatteryFull, contentDescription = "Battery", modifier = Modifier.rotate(90f))
                    }
                    IconButton(onClick = {}){
                        Icon(Icons.Default.Circle, contentDescription = "Status", tint= Color.Yellow)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                val currentRoute = navController.currentBackStackEntry?.destination?.route

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text(Screens.Home.title) },
                    selected = currentRoute == Screens.Home.name,
                    onClick = {
                        if (currentRoute != Screens.Home.name) {
                            navController.navigate(Screens.Home.name) {
                                // Use route name instead of graph id
                                popUpTo(Screens.Home.name) { inclusive = false }
                                launchSingleTop = true
                            }
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Functions") },
                    label = { Text(Screens.Functions.title) },
                    selected = currentRoute == Screens.Functions.name,
                    onClick = {
                        if (currentRoute != Screens.Functions.name) {
                            navController.navigate(Screens.Functions.name) {
                                popUpTo(Screens.Home.name)
                                launchSingleTop = true
                            }
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text(Screens.Settings.title) },
                    selected = currentRoute == Screens.Settings.name,
                    onClick = {
                        if (currentRoute != Screens.Settings.name) {
                            navController.navigate(Screens.Settings.name) {
                                popUpTo(Screens.Home.name)
                                launchSingleTop = true
                            }
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        content(innerPadding)
    }
}