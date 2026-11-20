package com.karyashala.erp.domain.attendance.attendanceSummary.model

data class AttendanceSummaryData(
    val pendingAttendanceCount: Int,
    val approvedAttendanceCount: Int,
    val rejectedAttendanceCount: Int,
    val forgottenAttendanceDaysCount: Int,
)
