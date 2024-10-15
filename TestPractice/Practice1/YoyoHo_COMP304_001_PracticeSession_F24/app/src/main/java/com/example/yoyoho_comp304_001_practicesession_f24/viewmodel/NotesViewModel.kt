package com.example.yoyoho_comp304_001_practicesession_f24.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class Note(
    val title: String,
    val content: String,
    val priority: String
)

class NotesViewModel : ViewModel() {
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    fun addNote(note: Note) {
        _notes.add(note)
    }
}
