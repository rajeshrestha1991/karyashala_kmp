package com.karyashala.erp.domain.note.allNotes.useCase

import com.karyashala.erp.domain.note.allNotes.mapper.toData
import com.karyashala.erp.domain.note.allNotes.model.NoteData
import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class NoteUseCase(
    private val noteRemoteRepository: NoteRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<NoteData>, DataError> {
        return noteRemoteRepository.fetchAllNotes().map {
            it.toData()
        }
    }
}