package com.example.navigation1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.navigation1.MyApplication
import com.example.navigation1.scaffold.NavScaffold
import com.example.navigation1.viewModel.SharedViewModel

@Composable
fun NavInfo() {
    // Create a NavController
    val navController = rememberNavController()

    val context = LocalContext.current
    val application = context.applicationContext as MyApplication

    // Create a SharedViewModel
    val sharedViewModel = remember {
        SharedViewModel(application.getRepository())
    }

    NavScaffold(navController, sharedViewModel)
}

