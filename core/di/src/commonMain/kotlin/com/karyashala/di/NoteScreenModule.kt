package com.karyashala.di

import com.karyashala.erp.addNoteScreen.AddNotesViewModel
import com.karyashala.erp.data.note.KtorNoteRemoteRepository
import com.karyashala.erp.detailNoteScreen.DetailNoteScreenViewModel
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.note.addNote.useCase.AddNoteUseCase
import com.karyashala.erp.domain.note.allNotes.repository.NoteRemoteRepository
import com.karyashala.erp.domain.note.allNotes.useCase.NoteUseCase
import com.karyashala.erp.domain.note.deleteNote.useCase.DeleteNoteUseCase
import com.karyashala.erp.domain.note.updateNote.useCase.UpdateNoteUseCase
import com.karyashala.erp.note.NoteViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class NoteScreenModule {
    @Factory(binds = [NoteRemoteRepository::class])
    fun noteRemoteRepository(httpClient: HttpClient): NoteRemoteRepository =
        KtorNoteRemoteRepository(httpClient = httpClient)

    @Factory
    fun noteUseCase(
        noteRemoteRepository: NoteRemoteRepository
    ): NoteUseCase = NoteUseCase(
        noteRemoteRepository = noteRemoteRepository
    )

    @Factory
    fun addNoteUseCase(
        noteRemoteRepository: NoteRemoteRepository
    ): AddNoteUseCase = AddNoteUseCase(
        noteRemoteRepository = noteRemoteRepository
    )

    @Factory
    fun updateNoteUseCase(
        noteRemoteRepository: NoteRemoteRepository
    ): UpdateNoteUseCase = UpdateNoteUseCase(
        noteRemoteRepository = noteRemoteRepository
    )

    @Factory
    fun deleteNoteUseCase(
        noteRemoteRepository: NoteRemoteRepository
    ): DeleteNoteUseCase = DeleteNoteUseCase(
        noteRemoteRepository = noteRemoteRepository
    )

    @KoinViewModel
    fun getAddNotesViewModel(
        requiredValidationUseCase: RequiredValidationUseCase,
        updateNoteUseCase: UpdateNoteUseCase,
        addNoteUseCase: AddNoteUseCase
    ): AddNotesViewModel = AddNotesViewModel(
        requiredValidationUseCase = requiredValidationUseCase,
        addNoteUseCase = addNoteUseCase,
        updateNoteUseCase = updateNoteUseCase
    )

    @KoinViewModel
    fun getNoteViewModel(
        deleteNoteUseCase: DeleteNoteUseCase,
        noteUseCase: NoteUseCase
    ): NoteViewModel = NoteViewModel(
        deleteNoteUseCase = deleteNoteUseCase,
        noteUseCase = noteUseCase
    )

    @KoinViewModel
    fun getDetailNoteScreenViewModel(
        deleteNoteUseCase: DeleteNoteUseCase,
    ): DetailNoteScreenViewModel = DetailNoteScreenViewModel(
        deleteNoteUseCase = deleteNoteUseCase
    )
}