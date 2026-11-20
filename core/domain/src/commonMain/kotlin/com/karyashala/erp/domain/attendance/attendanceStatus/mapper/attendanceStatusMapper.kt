package com.karyashala.erp.domain.attendance.attendanceStatus.mapper

import com.karyashala.erp.domain.attendance.attendanceStatus.model.AttendanceStatusData
import com.karyashala.model.attendance.attendanceStatus.AttendanceStatusResponseDTO

fun AttendanceStatusResponseDTO.toData(): List<AttendanceStatusData> {
    return detail?.map {
        AttendanceStatusData(
            requestedDate = it.requestedDate ?: "",
            requestRemarks = it.requestRemarks ?: "",
            clockInTime = it.clockInTime ?: "--:--",
            clockOutTime = it.clockOutTime ?: "--:--",
            assignedTo = it.assignedTo ?: "",
            approvedRemarks = it.approvedRemarks ?: "",
            lastModifiedBy = it.lastModifiedBy ?: "",
            lastModifiedDate = it.lastModifiedDate ?: "",
            attendanceStatus = it.attendanceStatus ?: "",
        )
    } ?: emptyList()
}
