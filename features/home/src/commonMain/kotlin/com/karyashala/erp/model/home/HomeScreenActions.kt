package com.karyashala.erp.model.home

import com.karyashala.erp.domain.upComingBirthday.model.UpComingBirthdayData

sealed interface HomeScreenActions {
    data object OnCheckInClicked : HomeScreenActions
    data object OnCheckOutClicked : HomeScreenActions

    data object OnNotificationClicked : HomeScreenActions
    data object OnSearchedClicked : HomeScreenActions
    data object OnRequestLeave : HomeScreenActions
    data object OnRequestAttendance : HomeScreenActions
    data class OnSpecificDayClicked(val date: String) : HomeScreenActions
    data class OnDateSelected(val day: Int) : HomeScreenActions

    data class SwipeToDismiss(val uri: String) : HomeScreenActions
    data object OnRefresh : HomeScreenActions

    data class OnSpecificUserClicked(val user: UpComingBirthdayData) : HomeScreenActions
}