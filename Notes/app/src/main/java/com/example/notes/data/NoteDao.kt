package com.example.notes.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM Note ORDER BY dateAdded DESC")
    fun getNotesByDateAdded(): Flow<List<Note>>

    @Query("SELECT * FROM Note ORDER BY title ASC")
    fun getNotesByTitle(): Flow<List<Note>>
}
