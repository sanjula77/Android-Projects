package com.example.notes.presentation

import com.example.notes.data.Note

data class NotesState(
    val notes: List<Note> = emptyList()
)
