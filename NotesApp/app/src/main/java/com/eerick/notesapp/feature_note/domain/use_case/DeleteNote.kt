package com.eerick.notesapp.feature_note.domain.use_case

import com.eerick.notesapp.feature_note.domain.model.Note
import com.eerick.notesapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNode(note)
    }
}