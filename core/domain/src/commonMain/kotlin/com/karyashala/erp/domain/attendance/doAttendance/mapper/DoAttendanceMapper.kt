package com.karyashala.erp.domain.attendance.doAttendance.mapper

import com.karyashala.erp.domain.attendance.doAttendance.model.DoAttendanceData
import com.karyashala.model.attendance.doAttendance.DoAttendanceResponseDto

fun DoAttendanceResponseDto.toData(): DoAttendanceData{
    return DoAttendanceData(
        message =  message ?: ""
    )
}