package com.karyashala.erp.domain.leave.leaveAssignee.mapper

import com.karyashala.erp.domain.leave.leaveAssignee.model.LeaveAssigneeData
import com.karyashala.model.leave.leaveAssignee.LeaveAssigneeResponseDto

fun LeaveAssigneeResponseDto.toData(): List<LeaveAssigneeData> {
    return detail?.map {
        LeaveAssigneeData(
            id = it.id ?: 0,
            fullName = it.fullName ?: "",
            email = it.email ?: "",
            phone = it.phone ?: "",
            branchId = it.branchId ?: 0,
            profileId = it.profileId ?: 0,
            maxApprovalLimit = it.maxApprovalLimit ?: 0,
            allowAttendanceApproval = it.allowAttendanceApproval ?: "",
        )
    } ?: emptyList()
}
