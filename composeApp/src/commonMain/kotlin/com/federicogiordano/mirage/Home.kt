package com.federicogiordano.mirage

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.federicogiordano.mirage.ui.components.AppScaffold
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import kotlin.math.atan2
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import androidx.compose.ui.platform.LocalDensity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.federicogiordano.mirage.api.LoginScreen
import com.federicogiordano.mirage.api.LoginService
import com.federicogiordano.mirage.functions.MapsList
import com.federicogiordano.mirage.functions.MissionsList
import com.federicogiordano.mirage.functions.SoundsList
import com.federicogiordano.mirage.viewmodel.LoginViewModel
import kotlinx.coroutines.delay

enum class Screens(val title: String) {
    Home("Home"),
    Functions("Functions"),
    Settings("Settings"),
    Login("Login"),
}


@Composable
fun App() {
    val navController = rememberNavController()
    val loginService = remember { LoginService() }
    val isLoggedIn by loginService.isLoggedIn.collectAsState(initial = false)

    val handleLogout = {
        loginService.logout()
        navController.navigate("login") {
            popUpTo(0) { inclusive = true }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screens.Login.name // Changed start destination
    ) {

        composable(Screens.Login.name) {
            val loginViewModel = remember { LoginViewModel(loginService) }
            LoginScreen(navController, loginViewModel)
        }

        composable(Screens.Home.name) {
            HomeView(navController, handleLogout)
        }

        composable(Screens.Functions.name) {
            FunctionsView(navController, handleLogout)
        }

        composable(Screens.Settings.name) {
            SettingsView(navController, handleLogout)
        }

        composable(
            route = "function/{functionId}",
            arguments = listOf(navArgument("functionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val functionId = backStackEntry.arguments?.getString("functionId")

            when (functionId) {
                "mapping" -> MapsList(navController)
                "missions" -> MissionsList(navController)
                "sounds" -> SoundsList(navController)
                "diagnostics" ->
                    FunctionSubScreen(functionId.replace("_", " ").capitalize(), navController)
                else -> FunctionSubScreen("Unknown Function", navController)
            }
        }
    }
}

@Composable
fun HomeView(
    navController: NavHostController = rememberNavController(),
    onLogout: () -> Unit = {}
) {
    var linearVelocity by remember { mutableStateOf(0f) }
    var angularVelocity by remember { mutableStateOf(0f) }
    val webSocketClient = remember { RobotWebSocketManager.getClient() }
    var isConnected by remember { mutableStateOf(false) }
    var isJoystickActive by remember { mutableStateOf(false) }

    LaunchedEffect(isJoystickActive, linearVelocity, angularVelocity) {
        while (isJoystickActive && isConnected) {
            webSocketClient.sendVelocity(linearVelocity, angularVelocity)
            delay(100)
        }
    }

    AppScaffold(
        navController = navController,
        currentScreen = Screens.Home,
        onLogout = onLogout
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    println("CLICKED MANUAL")
                    webSocketClient.requestManualControl()
                    isConnected = true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isConnected)
                        MaterialTheme.colorScheme.primaryContainer
                    else
                        MaterialTheme.colorScheme.primary
                )
            ) {
                Text(text = if (isConnected) "Manual Control Active" else "Activate Manual Control")
            }

            Spacer(modifier = Modifier.height(16.dp))

            JoystickController(
                modifier = Modifier.padding(32.dp),
                onVelocityChanged = { linear, angular ->
                    linearVelocity = linear
                    angularVelocity = -angular

                    isJoystickActive = kotlin.math.abs(linear) > 0.01f || kotlin.math.abs(angular) > 0.01f

                    if (!isJoystickActive && isConnected) {
                        webSocketClient.sendVelocity(0f, 0f)
                    }
                }
            )
        }
    }
}

@Composable
fun JoystickController(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    onVelocityChanged: (linear: Float, angular: Float) -> Unit
) {
    var center by remember { mutableStateOf(Offset.Zero) }
    var pointerOffset by remember { mutableStateOf(Offset.Zero) }
    val maxDistancePx = with(LocalDensity.current) { (size / 2).toPx() }

    Surface(
        modifier = modifier.size(size),
        tonalElevation = 8.dp,
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        println("SURFACE CONTROLLER")
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            val newOffset = pointerOffset + dragAmount
                            val distance = sqrt(
                                newOffset.x * newOffset.x +
                                        newOffset.y * newOffset.y
                            )

                            println("POINTER DRAGGED")

                            pointerOffset = if (distance > maxDistancePx) {
                                val angle = atan2(newOffset.y, newOffset.x)
                                Offset(
                                    cos(angle) * maxDistancePx,
                                    sin(angle) * maxDistancePx
                                )
                            } else newOffset

                            onVelocityChanged(
                                -pointerOffset.y / maxDistancePx,
                                pointerOffset.x / maxDistancePx
                            )
                        },
                        onDragEnd = {
                            pointerOffset = Offset.Zero
                            onVelocityChanged(0f, 0f)
                        }
                    )
                }
        ) {
            Canvas(
                modifier = Modifier
                    .size(size - 32.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
                    .background(MaterialTheme.colorScheme.surface)
                    .onGloballyPositioned { layoutCoordinates ->
                        center = Offset(
                            layoutCoordinates.size.width / 2f,
                            layoutCoordinates.size.height / 2f
                        )
                    }
            ) {}

            Surface(
                modifier = Modifier
                    .size(48.dp)
                    .graphicsLayer {
                        translationX = pointerOffset.x
                        translationY = pointerOffset.y
                    },
                shape = MaterialTheme.shapes.extraLarge,
                color = MaterialTheme.colorScheme.primary,
                tonalElevation = 4.dp
            ) {}
        }
    }
}

@Composable
fun FunctionsView(
    navController: NavHostController = rememberNavController(),
    onLogout: () -> Unit = {}
) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Functions,
        onLogout = onLogout
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
fun SettingsView(
    navController: NavHostController = rememberNavController(),
    onLogout: () -> Unit = {}
) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Settings,
        onLogout = onLogout
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

@Composable
fun LoginView(navController: NavHostController = rememberNavController()) {
    AppScaffold(
        navController = navController,
        currentScreen = Screens.Login
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginScreen(navController)
        }
    }
}
