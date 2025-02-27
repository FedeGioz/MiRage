package com.federicogiordano.mirage.ui.components

sealed class Screens(val screen: String) {
    data object Home: Screens("home")
    data object Functions: Screens("functions")
    data object Settings: Screens("settings")

}