package com.karyashala.erp.domain.attendance.attendanceSummary.mapper

import com.karyashala.erp.domain.attendance.attendanceSummary.model.AttendanceSummaryData
import com.karyashala.model.attendance.attendanceSummary.AttendanceSummaryResponseDto

fun AttendanceSummaryResponseDto.toData(): AttendanceSummaryData{
    return AttendanceSummaryData(
        pendingAttendanceCount = detail?.pendingAttendanceCount ?: 0,
        approvedAttendanceCount = detail?.approvedAttendanceCount ?: 0,
        rejectedAttendanceCount = detail?.rejectedAttendanceCount ?: 0,
        forgottenAttendanceDaysCount = detail?.forgottenAttendanceDaysCount ?: 0
    )
}