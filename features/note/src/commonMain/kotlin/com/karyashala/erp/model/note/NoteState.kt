package com.karyashala.erp.model.note

import com.karyashala.erp.domain.note.allNotes.model.NoteData
import com.karyashala.model.note.ui.AddedNoteDataUi

data class NoteState(
    val noteItem: List<NoteData> = emptyList(),
    val isFetchingNotes: Boolean = false,
    val hasUpdatedData: Boolean = false,
    val isDeletingData : Boolean = false,
    val selectedId : Int? = null,
    val isUpdate : Boolean = false,
    val noteItemToEdit : AddedNoteDataUi? = null,
    val isRefreshing : Boolean = false
)
