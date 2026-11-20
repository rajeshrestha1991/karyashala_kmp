package com.karyashala.erp.domain.leave.leaveSummary.useCase

import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.domain.leave.leaveSummary.mappper.toData
import com.karyashala.erp.domain.leave.leaveSummary.model.LeaveSummaryData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class LeaveSummaryUseCase(
    private val leaveRemoteRepository: LeaveRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<LeaveSummaryData, DataError>{
        return leaveRemoteRepository.fetchLeaveSummary().map {
            it.toData()
        }
    }
}