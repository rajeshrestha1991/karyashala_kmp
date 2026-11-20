package com.karyashala.erp.domain.attendance.attendanceStatus.useCase

import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.attendanceStatus.mapper.toData
import com.karyashala.erp.domain.attendance.attendanceStatus.model.AttendanceStatusData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError


class AttendanceStatusUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository
) {
    suspend operator fun invoke(
        attendanceStatus: String,
        employeeName: String,
        isSelf: String,
        fromDate: String,
        toDate: String
    ): ERPResult<List<AttendanceStatusData>, DataError> {
        return attendanceRemoteRepository.fetchAttendanceStatus(
            attendanceStatus,
            employeeName,
            isSelf,
            fromDate,
            toDate
        ).map {
            it.toData()
        }
    }
}
