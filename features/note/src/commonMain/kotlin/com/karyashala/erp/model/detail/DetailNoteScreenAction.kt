package com.karyashala.erp.model.detail

interface DetailNoteScreenAction {
    data class OnDeleteNote(val id: Int?): DetailNoteScreenAction
}