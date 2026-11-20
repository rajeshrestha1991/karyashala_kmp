package com.karyashala.erp.profile.model.profileinfo_screen

interface ProfileInfoViewAction {
    data class OnItemSelected(val index: InfoList) : ProfileInfoViewAction
    data object OnRefresh: ProfileInfoViewAction

}