package com.karyashala.erp.domain.leave.leaveReport.useCase

import com.karyashala.erp.domain.leave.leaveReport.mapper.toData
import com.karyashala.erp.domain.leave.leaveReport.model.LeaveReportData
import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class LeaveReportUseCase(
    private val leaveRemoteRepository: LeaveRemoteRepository
) {
    suspend operator fun invoke(
        leaveStatus: String,
        fromDate: String,
        toDate: String
    ): ERPResult<List<LeaveReportData>, DataError> {
        return leaveRemoteRepository.fetchLeaveReport(
            fromDate = fromDate,
            toDate = toDate,
            leaveStatus = leaveStatus
        ).map {
            it.toData()
        }
    }
}