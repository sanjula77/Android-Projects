package com.example.notes.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.notes.data.Note


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotesScreen(
    state: NotesState,
    navController: NavController,
    onEvent: (NotesEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("AddNoteScreen") }) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(16.dp)) {
            items(state.notes) { note ->
                NoteItem(note, onEvent)
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, onEvent: (NotesEvent) -> Unit) {
    Card(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { }
    ) {
        Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Text(text = note.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

