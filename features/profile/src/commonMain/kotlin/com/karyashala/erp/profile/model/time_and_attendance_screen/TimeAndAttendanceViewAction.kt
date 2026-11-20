package com.karyashala.erp.profile.model.time_and_attendance_screen

import com.karyashala.erp.components.date.DateData


sealed interface TimeAndAttendanceViewAction {
    data class fromDate(val date: DateData) : TimeAndAttendanceViewAction
    data class toDate(val date: DateData) : TimeAndAttendanceViewAction

    data object Submit : TimeAndAttendanceViewAction

    data object OnRefresh: TimeAndAttendanceViewAction
}