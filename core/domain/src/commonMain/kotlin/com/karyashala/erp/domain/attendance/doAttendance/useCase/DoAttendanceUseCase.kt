package com.karyashala.erp.domain.attendance.doAttendance.useCase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.doAttendance.mapper.toData
import com.karyashala.erp.domain.attendance.doAttendance.model.DoAttendanceData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class DoAttendanceUseCase(
    private val attendanceRemoteRepository: AttendanceRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        forDate: String,
        imageName: String

    ): ERPResult<DoAttendanceData, DataError>{
        val id = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return attendanceRemoteRepository.doAttendance(
            employeeId=id,
            forDate= forDate,
            imageName= imageName
        ).map {
            it.toData()
        }
    }
}