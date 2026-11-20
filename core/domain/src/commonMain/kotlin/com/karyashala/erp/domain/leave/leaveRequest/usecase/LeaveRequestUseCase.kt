package com.karyashala.erp.domain.leave.leaveRequest.usecase

import com.karyashala.erp.domain.leave.leaveRequest.mapper.toData
import com.karyashala.erp.domain.leave.leaveRequest.model.LeaveRequestData
import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class LeaveRequestUseCase(
    private val leaveRemoteRepository: LeaveRemoteRepository
) {
    suspend operator fun invoke(
        startDate: String,
        endDate: String,
        leaveDuration: String,
        leaveTypeId: Int,
        reason: String,
        assigneeId: Int
    ): ERPResult<LeaveRequestData, DataError> {
        return leaveRemoteRepository.requestLeave(
            startDate = startDate,
            endDate = endDate,
            leaveDuration = leaveDuration,
            leaveTypeId = leaveTypeId,
            reason = reason,
            assigneeId = assigneeId
        ).map {
            it.toData()
        }
    }
}