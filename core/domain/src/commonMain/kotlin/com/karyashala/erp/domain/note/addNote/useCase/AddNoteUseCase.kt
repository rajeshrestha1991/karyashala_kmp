package com.karyashala.erp.domain.note.addNote.useCase

import com.karyashala.erp.domain.note.addNote.mapper.toData
import com.karyashala.erp.domain.note.addNote.model.AddNoteData
import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class AddNoteUseCase(
    private val noteRemoteRepository: NoteRemoteRepository
) {
    suspend operator fun invoke(
        active: String,
        description: String,
        endTime: String,
        isEvent: String,
        isReminder: String,
        location: String,
        reminderMessage: String,
        reminderTime: String,
        startTime: String,
        title: String,
        startDate: String,
        endDate: String,
    ): ERPResult<AddNoteData, DataError> {
        return noteRemoteRepository.addNote(
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
            startDate = startDate,
            endDate = endDate,
        ).map {
            it.toData()
        }
    }

}