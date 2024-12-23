package com.example.notesapp

import android.content.Context
import androidx.room.Room

object DatabaseInstance {
    private var INSTANCE: NoteDatabase? = null

    fun getDatabase(context: Context): NoteDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_database"
            ).build()
        }
        return INSTANCE!!
    }
}
