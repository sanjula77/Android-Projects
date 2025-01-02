package com.example.navigation1.scaffold

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.example.navigation1.screens.ScreenOne
import com.example.navigation1.screens.ScreenThree
import com.example.navigation1.screens.ScreenTwo


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavScaffold(navController: NavHostController) {

    val isBackEnabled =  remember {
        mutableStateOf(false)
    }

    navController.addOnDestinationChangedListener {
            controller,
            destination,
            arguments ->

        Log.d("NavController", "Navigated to: ${destination.route}")
        isBackEnabled.value = destination.route == "screen_one"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(text = "Navigation", style = MaterialTheme.typography.labelLarge)
                },
                navigationIcon = {
                    val navIcon = if(isBackEnabled.value) {
                        Icons.Filled.Home
                    } else {
                        Icons.Filled.ArrowBack
                    }
                    IconButton(
                        onClick = { if (!isBackEnabled.value) {
                            navController.popBackStack()
                          }
                        }
                    ) {
                        Icon(
                            imageVector = navIcon,
                            contentDescription = "home"
                        )
                    }
                }
            )
        },

    ) {
        // Rest of the content
        paddingValues ->

        NavHost(navController = navController, graph = getMyNavGraph(navController, paddingValues))
    }
}

// Define the navigation graph
fun NavGraphBuilder.navigationGraph(navController: NavController, paddingValues: PaddingValues) {
    composable("screen_one") {
        ScreenOne(navController, modifier = Modifier.padding(paddingValues))
    }
    composable("screen_two") {
        ScreenTwo(navController, modifier = Modifier.padding(paddingValues))
    }
    composable("screen_three") {
        ScreenThree(navController, modifier = Modifier.padding(paddingValues))
    }
}

// Create the NavGraph
fun getMyNavGraph(controller: NavController, paddingValues: PaddingValues): NavGraph {
    return controller.createGraph(startDestination = "screen_one") {
        composable("screen_one") {
            ScreenOne(controller, modifier = Modifier.padding(paddingValues))
        }
        composable("screen_two") {
            ScreenTwo(controller,modifier = Modifier.padding(paddingValues))
        }
        composable("screen_three") {
            ScreenThree(controller, modifier = Modifier.padding(paddingValues))
        }
    }
}