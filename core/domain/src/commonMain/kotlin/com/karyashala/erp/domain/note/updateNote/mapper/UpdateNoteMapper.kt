package com.karyashala.erp.domain.note.updateNote.mapper

import com.karyashala.erp.domain.note.updateNote.model.UpdateNoteData
import com.karyashala.model.note.NotesResponseDto

fun NotesResponseDto.toData(): UpdateNoteData{
    return UpdateNoteData(
        status = status ?: "",
        success = success ?: false,
        message = message ?: ""
    )
}