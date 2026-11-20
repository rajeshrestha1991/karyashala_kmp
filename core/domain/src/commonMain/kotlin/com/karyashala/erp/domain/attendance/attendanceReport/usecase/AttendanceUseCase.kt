package com.karyashala.erp.domain.attendance.attendanceReport.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.attendance.attendanceReport.mapper.toData
import com.karyashala.erp.domain.attendance.attendanceReport.model.AttendanceData
import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class AttendanceUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        fromDate: String? = null,
        toDate: String? = null,
        attendanceStatus: String? = null ,
        employeeId: Int? = null
    ): ERPResult<List<AttendanceData>, DataError> {
        val id = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0

        return attendanceRemoteRepository.fetchAttendance(
            dateFrom = fromDate ,
            toDate = toDate,
            attendanceStatus = attendanceStatus,
            employeeId= id
        ).map {
            it.toData()
        }
    }
}