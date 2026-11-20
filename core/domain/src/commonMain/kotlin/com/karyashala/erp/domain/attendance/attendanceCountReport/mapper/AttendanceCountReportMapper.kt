package com.karyashala.erp.domain.attendance.attendanceCountReport.mapper

import com.karyashala.erp.domain.attendance.attendanceCountReport.model.AttendanceCountReportData
import com.karyashala.model.attendance.attendanceCountReport.AttendanceCountReportResponseDto

fun AttendanceCountReportResponseDto.toData(): AttendanceCountReportData{
    return AttendanceCountReportData(
        present = detail?.PRESENT ?: 0,
        absent = detail?.ABSENT ?: 0
    )
}