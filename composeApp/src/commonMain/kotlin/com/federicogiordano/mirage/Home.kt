package com.federicogiordano.mirage

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.federicogiordano.mirage.ui.HomeViewModel
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.*
import com.federicogiordano.mirage.ui.components.AppScaffold

enum class Screens(val title: String) {
    Home("Home"),
    Functions("Functions"),
    Settings("Settings")
}


@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Home.name
    ) {
        composable(Screens.Home.name) {
            HomeView(navController)
        }
        composable(Screens.Functions.name) {
            FunctionsView(navController)
        }
        composable(Screens.Settings.name) {
            SettingsView(navController)
        }
    }
}

@Composable
fun HomeView(navController: NavHostController = rememberNavController()) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Home
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Home Screen")
        }
    }
}

@Composable
fun FunctionsView(navController: NavHostController = rememberNavController()) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Functions
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Functions(navController)
        }
    }
}

@Composable
fun SettingsView(navController: NavHostController = rememberNavController()) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Settings
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Settings Screen")
        }
    }
}