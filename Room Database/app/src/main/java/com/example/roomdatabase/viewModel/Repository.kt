package com.example.roomdatabase.viewModel

import com.example.roomdatabase.roomDb.Note
import com.example.roomdatabase.roomDb.NoteDatabase

class Repository(private val db: NoteDatabase) {
    suspend fun upsertNote(note: Note) {
        db.dao.upsertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        db.dao.deleteNote(note)
    }

    fun getAllNotes() = db.dao.getAllNotes()
}
