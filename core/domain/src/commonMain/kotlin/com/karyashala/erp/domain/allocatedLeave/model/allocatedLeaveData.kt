package com.karyashala.erp.domain.allocatedLeave.model

data class AllocatedLeaveData(
    val leaveType: String,
    val totalDays: Double,
    val leaveTaken: Double,
    val remainingLeave: Double,
)