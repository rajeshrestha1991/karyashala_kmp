package com.karyashala.erp.data.note

import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.note.NotesRequestDto
import com.karyashala.model.note.NotesResponseDto
import com.karyashala.model.note.NotesUpdateRequestDto
import com.karyashala.model.note.addNote.AddNoteResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorNoteRemoteRepository(
    private val httpClient: HttpClient
) : NoteRemoteRepository {
    override suspend fun fetchAllNotes(): ERPResult<NotesResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ALL_NOTES_END_POINT
            )
        }
    }

    override suspend fun addNote(
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
        endDate: String
    ): ERPResult<AddNoteResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.CREATE_NOTE_END_POINT
            ) {
                setBody(
                    NotesRequestDto(
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
                        )
                )
            }
        }
    }

    override suspend fun updateNote(
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
    ): ERPResult<NotesResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.UPDATE_NOTE_END_POINT
            ){
                setBody(NotesUpdateRequestDto(
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
                    id = id,
                ))
            }
        }
    }

    override suspend fun deleteNote(id: Int): ERPResult<NotesResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.DELETE_NOTE_END_POINT+"/$id"
            )
        }
    }
}