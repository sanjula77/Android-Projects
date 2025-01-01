package com.example.navigation

sealed class Screen(val rout: String) {
    data object Home : Screen("home")
    data object Second : Screen("second")
    data object Last : Screen("last")
}