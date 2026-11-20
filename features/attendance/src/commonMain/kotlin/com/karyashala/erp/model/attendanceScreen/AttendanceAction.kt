package com.karyashala.erp.model.attendanceScreen

interface AttendanceAction {
    data class OnStatusChange(val status: TabItemsEnums) : AttendanceAction

    data class OnUpdateAttendanceJsonData( val json : String?): AttendanceAction
    data object OnRefresh: AttendanceAction
}