package com.example.notes.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.NoteDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val dao: NoteDao
): ViewModel() {

    private val isSortedByDateAdded: MutableStateFlow<Boolean> = MutableStateFlow(true)

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    dao.deleteNote(event.note)
                }
            }

            is NotesEvent.SaveNote -> {
                val title = event.title
                val description = event.description
            }

            is NotesEvent.SortNotes -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }
        }

    }
}