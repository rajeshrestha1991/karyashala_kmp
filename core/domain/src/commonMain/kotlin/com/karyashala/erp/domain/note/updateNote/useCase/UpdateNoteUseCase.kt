package com.karyashala.erp.domain.note.updateNote.useCase

import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.domain.note.updateNote.mapper.toData
import com.karyashala.erp.domain.note.updateNote.model.UpdateNoteData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class UpdateNoteUseCase(
    private val noteRemoteRepository: NoteRemoteRepository
) {
    suspend operator fun invoke(
        id: Int,
        title: String,
        description: String,
        isEvent: String,
        isReminder: String,
        active: String,
        location: String,
        startTime: String,
        endTime: String,
        reminderMessage: String,
        reminderTime: String
    ): ERPResult<UpdateNoteData, DataError> {
        return noteRemoteRepository.updateNote(
            active = active,
            description = description,
            endTime = endTime,
            isEvent = isEvent,
            isReminder = isReminder,
            location = location,
            reminderMessage = reminderMessage,
            reminderTime = reminderTime,
            startTime = startTime,
            title = title,
            id = id
        ).map {
            it.toData()
        }
    }
}