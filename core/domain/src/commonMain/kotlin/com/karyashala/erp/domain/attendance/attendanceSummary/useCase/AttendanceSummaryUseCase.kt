package com.karyashala.erp.domain.attendance.attendanceSummary.useCase

import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.attendanceSummary.mapper.toData
import com.karyashala.erp.domain.attendance.attendanceSummary.model.AttendanceSummaryData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class AttendanceSummaryUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<AttendanceSummaryData, DataError> {
        return attendanceRemoteRepository.fetchAttendanceSummary().map {
            it.toData()
        }
    }
}