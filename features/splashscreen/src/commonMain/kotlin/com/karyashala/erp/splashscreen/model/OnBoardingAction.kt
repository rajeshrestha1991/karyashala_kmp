package com.karyashala.erp.splashscreen.model

sealed interface OnBoardingAction {
    data object CheckFirstUser : OnBoardingAction
    data object OnNext: OnBoardingAction

    data class SetCurrentPage(val page: Int) : OnBoardingAction
}