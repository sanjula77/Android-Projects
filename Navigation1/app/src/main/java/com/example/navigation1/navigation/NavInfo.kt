package com.example.navigation1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.navigation1.scaffold.NavScaffold
import com.example.navigation1.viewModel.SharedViewModel

@Composable
fun NavInfo() {
    // Create a NavController
    val navController = rememberNavController()

    // Create a SharedViewModel
    val sharedViewModel = remember {
        SharedViewModel()
    }

    NavScaffold(navController, sharedViewModel)
}

