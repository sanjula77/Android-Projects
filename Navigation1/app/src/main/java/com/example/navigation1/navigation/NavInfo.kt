package com.example.navigation1.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.navigation1.scaffold.NavScaffold
import com.example.navigation1.screens.ScreenOne
import com.example.navigation1.screens.ScreenThree
import com.example.navigation1.screens.ScreenTwo

@Composable
fun NavInfo() {
    // Create a NavController
    val navController = rememberNavController()

    NavScaffold(navController)

}

