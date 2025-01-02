package com.example.navigation1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation1.Student
import kotlinx.serialization.json.Json

private val json = Json { prettyPrint = true }

@Composable
fun ScreenTwo(navController: NavController, modifier: Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Screen Two",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(50.dp))

            val jsonData = navController.currentBackStackEntry?.arguments?.getString("data") ?: "No data available"
            val sampleStudent = json.decodeFromString(Student.serializer(), jsonData)

            Text(text = "Name: ${sampleStudent.name}")
            Text(text = "Age: ${sampleStudent.age}")
            Text(text = "Grade: ${sampleStudent.grade}")
            Text(text = "Email: ${sampleStudent.email}")

            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {navController.navigate("screen_three")}) {
                Text(
                    text = "screen Three"
                )
            }
            Button(onClick = {navController.popBackStack()}) {
                Text(
                    text = "Back"
                )
            }
        }
    }
}