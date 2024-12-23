package com.example.notesapp

import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notes WHERE title LIKE :query OR content LIKE :query")
    suspend fun searchNotes(query: String): List<Note>
}
