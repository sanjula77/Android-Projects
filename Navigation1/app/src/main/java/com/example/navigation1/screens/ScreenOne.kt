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
import com.example.navigation1.data.Student
import com.example.navigation1.viewModel.SharedViewModel

@Composable
fun ScreenOne(navController: NavController, sharedViewModel: SharedViewModel) {

    val sampleStudent = Student(
        id = 1,
        name = "John Doe",
        age = 20,
        grade = "A",
        email = "john@example.com"
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

            Text(
                text = "Screen One",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                sharedViewModel.student.value = sampleStudent
                navController.navigate("screen_two")})
            {
                Text(
                    text = "screen two"
                )
            }
        }
    }
}