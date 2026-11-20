package com.karyashala.erp.model.viewAll

sealed interface ViewAllScreenAction {
    data class OnJsonUpdate(val json : String): ViewAllScreenAction
    data class OnTitleUpdate(val title : String): ViewAllScreenAction
}