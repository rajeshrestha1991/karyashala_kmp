package com.karyashala.erp.domain.leave.leaveRequest.mapper

import com.karyashala.erp.domain.leave.leaveRequest.model.LeaveRequestData
import com.karyashala.model.leave.leaveRequest.LeaveRequestResponseDto

fun LeaveRequestResponseDto.toData(): LeaveRequestData {
    return LeaveRequestData(
        status = status ?: "",
        message = message ?: "",
        success = success ?: true
    )
}