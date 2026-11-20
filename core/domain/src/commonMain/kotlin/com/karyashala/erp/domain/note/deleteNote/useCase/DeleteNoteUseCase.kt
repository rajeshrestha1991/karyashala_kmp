package com.karyashala.erp.domain.note.deleteNote.useCase

import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.domain.note.deleteNote.mapper.toData
import com.karyashala.erp.domain.note.deleteNote.model.DeleteNoteData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class DeleteNoteUseCase(
    private val noteRemoteRepository: NoteRemoteRepository
) {
    suspend operator fun invoke(
        id:Int
    ): ERPResult<DeleteNoteData, DataError>{
        return noteRemoteRepository.deleteNote(id = id).map {
            it.toData()
        }
    }
}