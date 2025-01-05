package com.example.roomdatabase.roomDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
