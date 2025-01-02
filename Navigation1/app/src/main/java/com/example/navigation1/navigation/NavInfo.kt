package com.example.navigation1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation1.scaffold.NavScaffold

@Composable
fun NavInfo() {
    // Create a NavController
    val navController = rememberNavController()
    NavScaffold(navController)
}

