package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.data.NotesDatabase
import com.example.notes.presentation.AddNoteScreen
import com.example.notes.presentation.NotesScreen
import com.example.notes.presentation.NotesViewModel
import com.example.notes.presentation.NotesViewModelFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            NotesDatabase::class.java,
            "notes_db"
        ).build()

        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val viewModel: NotesViewModel = viewModel(factory = NotesViewModelFactory(database.noteDao()))

                NavHost(navController, startDestination = "notes_screen") {
                    composable("notes_screen") {
                        NotesScreen(state = viewModel.state.collectAsState().value, navController, viewModel::onEvent)
                    }
                    composable("AddNoteScreen") {
                        AddNoteScreen(navController, viewModel::onEvent)
                    }
                }
            }
        }
    }
}
