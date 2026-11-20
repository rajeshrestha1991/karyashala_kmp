package com.karyashala.erp.domain.attendance.attendanceCountReport.useCase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.attendance.attendanceCountReport.mapper.toData
import com.karyashala.erp.domain.attendance.attendanceCountReport.model.AttendanceCountReportData
import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class AttendanceCountReportUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        toDate: String,
        fromDate: String
    ): ERPResult<AttendanceCountReportData, DataError>{
        val id = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return attendanceRemoteRepository.attendanceCountReportFetch(
            employeeId = id,
            toDate = toDate,
            fromDate = fromDate
        ).map {
            it.toData()
        }
    }
}