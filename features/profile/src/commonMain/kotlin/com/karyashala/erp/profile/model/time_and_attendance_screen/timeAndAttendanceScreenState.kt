package com.karyashala.erp.profile.model.time_and_attendance_screen


import com.karyashala.erp.components.date.DateData
import com.karyashala.erp.domain.attendance.attendanceReport.model.AttendanceData
import org.jetbrains.compose.resources.StringResource

data class TimeAndAttendanceState(
    val isLoading: Boolean = false,
    val timeAndAttendanceList: List<AttendanceData> = emptyList(),
    val fromDate: DateData? = null,
    val toDate: DateData? = null,
    val employeeId: Int? = null,
    val attendanceStatus: String? = null,

    val fromDateError: StringResource? = null,
    val toDateError: StringResource? = null,

    val isRefreshing: Boolean = false

)