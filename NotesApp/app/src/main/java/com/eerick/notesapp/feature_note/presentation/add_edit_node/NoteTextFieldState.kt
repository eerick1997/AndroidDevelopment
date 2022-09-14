package com.eerick.notesapp.feature_note.presentation.add_edit_node

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
