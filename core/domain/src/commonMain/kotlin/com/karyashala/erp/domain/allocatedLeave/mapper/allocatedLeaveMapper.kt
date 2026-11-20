package com.karyashala.erp.domain.allocatedLeave.mapper

import com.karyashala.erp.domain.allocatedLeave.model.AllocatedLeaveData
import com.karyashala.model.allocatedLeave.AllocatedLeaveResponseDto

fun AllocatedLeaveResponseDto.toData(): List<AllocatedLeaveData> {
    return detail?.map {
        AllocatedLeaveData(
            leaveType = it.leaveType?: "",
            totalDays = it.totalDaysAllowed?: 0.0,
            leaveTaken = it.totalDaysTaken?: 0.0,
            remainingLeave = it.totalDaysAssign?:0.0,
        )
}?: emptyList()}