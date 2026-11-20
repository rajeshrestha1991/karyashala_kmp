package com.karyashala.erp.domain.attendance.attendanceRequest.useCase

import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.attendanceRequest.mapper.toData
import com.karyashala.erp.domain.attendance.attendanceRequest.model.AttendanceRequestData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class AttendanceRequestUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository
) {
    suspend operator fun invoke(
        assigneeId: Int,
        clockInTime: String? = "",
        clockOutTime: String? = "",
        date: String,
        remarks: String
    ): ERPResult<AttendanceRequestData, DataError> {
        return attendanceRemoteRepository.requestAttendance(
            assigneeId = assigneeId,
            clockInTime = clockInTime,
            clockOutTime = clockOutTime,
            date = date,
            remarks = remarks
        ).map { it.toData() }
    }
}