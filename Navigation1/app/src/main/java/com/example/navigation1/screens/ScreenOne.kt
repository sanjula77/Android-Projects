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

@Composable
fun ScreenOne(navController: NavController, modifier: Modifier) {

    val sampleStudent = Student (
        name = "John Doe",
        age = 20,
        grade = "A",
        email = "harrison@example.com"
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val json = Json { prettyPrint = true }
            val data = json.encodeToString(Student.serializer(), sampleStudent)

            Text(
                text = "Screen One",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {navController.navigate("screen_two/$data")}) {
                Text(
                    text = "screen two"
                )
            }
        }
    }
}