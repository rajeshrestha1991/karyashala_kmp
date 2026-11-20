package com.karyashala.erp.profile.model.document_screen

interface DocumentScreenAction {
    data class OnSelectedDocument(val type : String): DocumentScreenAction
    data class OnReceivedDocumentUri(val uri : String): DocumentScreenAction

    data class OnLongPressed(val image: String): DocumentScreenAction

    data object OnLongPressedDismiss: DocumentScreenAction

}