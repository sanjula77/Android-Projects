package com.example.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(
    navController: NavHostController,
    backStackEntry: NavBackStackEntry
) {
    val url = backStackEntry.arguments?.getString("url")
    val tld = backStackEntry.arguments?.getString("tld")
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Second Screen",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "$url$tld",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.Last.rout)
            }
        ) {
            Text(
                text = "Go to Last "
            )
        }

    }
}