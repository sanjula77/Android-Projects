package com.example.roomdatabase.roomDb

import androidx.room.Database

@Database (
    entities = [Note::class],
    version = 1
)
 abstract class NoteDatabase {
     abstract val dao: RoomDao
}