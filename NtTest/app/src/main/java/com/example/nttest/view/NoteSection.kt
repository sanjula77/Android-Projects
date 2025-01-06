package com.example.nttest.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NoteSection() {
    LazyColumn {
        items(noteItems.size) {
            NoteCard(noteItems[it])
        }
    }
}

@Composable
fun NoteCard(noteItem: NoteItem) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(vertical = 8.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp), // Adds spacing between Text fields
                modifier = Modifier.weight(1f) // Pushes Icon to the right
            ) {
                Text(
                    text = noteItem.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = noteItem.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Icon(
                imageVector = noteItem.icon,
                contentDescription = noteItem.title,
                tint = noteItem.color,
                modifier = Modifier
                    .padding(start = 16.dp) // Adds padding between Column and Icon
                    .clickable {  }
            )
        }
    }
}

val noteItems = listOf(
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    ),
    NoteItem(
        title = "First Note",
        content = "Hi this is my first note and this is the content of it",
        color = Gray,
        icon = Icons.Rounded.Delete
    )
)
data class NoteItem(
    val title: String,
    val content: String,
    val color: Color,
    val icon: ImageVector
)