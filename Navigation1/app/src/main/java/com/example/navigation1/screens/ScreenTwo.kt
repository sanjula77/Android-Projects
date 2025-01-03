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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigation1.MyApplication


@Composable
fun ScreenTwo(navController: NavController) {

    val context = LocalContext.current
    val myApplication = context.applicationContext as MyApplication

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

            val stringId = navController.currentBackStackEntry?.arguments?.getString("id") ?: "0"
            val data = stringId.toInt()
            val student = myApplication.getRepository().getStudent(data)

            Text(text = "Student ID: ${student.id}")
            Text(text = "Name: ${student.name}")
            Text(text = "Age: ${student.age}")
            Text(text = "Grade: ${student.grade}")
            Text(text = "Email: ${student.email}")

            Spacer(modifier = Modifier.height(50.dp))
            // Navigation to Screen Three
            Button(onClick = { navController.navigate("screen_three") }) {
                Text(text = "screen Three")
            }

            // Navigate back to the previous screen
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back")
            }
        }
    }
}
