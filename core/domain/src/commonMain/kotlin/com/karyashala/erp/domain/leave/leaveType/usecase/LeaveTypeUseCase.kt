package com.karyashala.erp.domain.leave.leaveType.usecase

import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.domain.leave.leaveType.mapper.toData
import com.karyashala.erp.domain.leave.leaveType.model.LeaveTypeData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class LeaveTypeUseCase(
    private val leaveRemoteRepository: LeaveRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<LeaveTypeData>, DataError> {
        return leaveRemoteRepository.fetchLeaveType().map {
            it.toData()
        }
    }
}