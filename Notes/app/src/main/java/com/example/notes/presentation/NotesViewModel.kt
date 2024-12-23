package com.example.notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.data.Note
import com.example.notes.data.NoteDao
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesViewModel(private val dao: NoteDao) : ViewModel() {

    private val isSortedByDate = MutableStateFlow(true)

    private val notesFlow: Flow<List<Note>> = isSortedByDate.flatMapLatest { isSorted ->
        if (isSorted) dao.getNotesByDateAdded() else dao.getNotesByTitle()
    }

    val state: StateFlow<NotesState> = notesFlow
        .map { notes -> NotesState(notes = notes) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NotesState())

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote -> viewModelScope.launch { dao.deleteNote(event.note) }
            is NotesEvent.SaveNote -> viewModelScope.launch {
                dao.upsertNote(
                    Note(
                        title = event.title,
                        description = event.description,
                        dateAdded = System.currentTimeMillis()
                    )
                )
            }
            NotesEvent.SortNotes -> isSortedByDate.value = !isSortedByDate.value
        }
    }
}
