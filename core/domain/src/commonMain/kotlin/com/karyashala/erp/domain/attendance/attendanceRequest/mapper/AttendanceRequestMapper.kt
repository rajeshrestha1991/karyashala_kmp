package com.karyashala.erp.domain.attendance.attendanceRequest.mapper

import com.karyashala.erp.domain.attendance.attendanceRequest.model.AttendanceRequestData
import com.karyashala.model.attendance.attendanceRequest.AttendanceRequestResponseDto

fun AttendanceRequestResponseDto.toData(): AttendanceRequestData{
    return AttendanceRequestData(
        status = status ?: "",
        message = message ?: "",
        success = success ?: false
    )
}