package com.karyashala.erp.domain.leave.leaveType.mapper

import com.karyashala.erp.domain.leave.leaveType.model.LeaveTypeData
import com.karyashala.model.leave.leaveType.LeaveTypeResponseDto

fun LeaveTypeResponseDto.toData(): List<LeaveTypeData> {
    return detail?.map {
        LeaveTypeData(
            id = it.id ?: 0,
            createdDate = it.createdDate ?: "",
            createdByUserId = it.createdByUserId ?: 0,
            createdBy = it.createdBy ?: "",
            modifiedBy = it.modifiedBy ?: "",
            lastModified = it.lastModified ?: "",
            typeName = it.typeName ?: "",
            maxDaysAllowed = it.maxDaysAllowed ?: 0,
            active = it.active ?: "",
            accumulate = it.accumulate ?: "",
            enableCountWeekend = it.enableCountWeekend ?: "",
            enableCountHoliday = it.enableCountHoliday ?: "",
        )
    } ?: emptyList()
}