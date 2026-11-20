package com.karyashala.erp.domain.note.deleteNote.mapper

import com.karyashala.erp.domain.note.deleteNote.model.DeleteNoteData
import com.karyashala.model.note.NotesResponseDto

fun NotesResponseDto.toData(): DeleteNoteData{
    return DeleteNoteData(
        success = success ?: false,
        message = message ?: "",
        status = status ?: ""
    )
}