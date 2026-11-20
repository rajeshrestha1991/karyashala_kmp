package com.karyashala.erp.domain.leave.leaveAssignee.usecase

import com.karyashala.erp.domain.leave.leaveAssignee.mapper.toData
import com.karyashala.erp.domain.leave.leaveAssignee.model.LeaveAssigneeData
import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class AssigneeUseCase(
    private val leaveRemoteRepository: LeaveRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<LeaveAssigneeData>, DataError> {
        return leaveRemoteRepository.fetchAssignee().map {
            it.toData()
        }
    }
}