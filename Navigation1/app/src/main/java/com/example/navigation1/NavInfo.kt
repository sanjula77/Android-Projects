package com.example.navigation1

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavInfo() {
    // Create a NavController
    val navController = rememberNavController()

    // Create a NavHost
    NavHost(navController = navController, startDestination = "screen_one") {
        navigationGraph(navController = navController)
    }
}

// Define the navigation graph
fun NavGraphBuilder.navigationGraph(navController: NavController) {

    composable("screen_one") {
        ScreenOne(navController)
    }
    composable("screen_two") {
        ScreenTwo(navController)
    }
    composable("screen_three") {
        ScreenThree(navController)
    }
}