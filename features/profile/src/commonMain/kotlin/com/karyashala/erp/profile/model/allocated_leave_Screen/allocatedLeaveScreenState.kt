package com.karyashala.erp.profile.model.allocated_leave_Screen

import com.karyashala.erp.domain.allocatedLeave.model.AllocatedLeaveData

data class AllocatedLeaveState(
    val isLoading: Boolean = false,
    val leaveSummaryList: List<AllocatedLeaveData> = emptyList(),
    val isRefreshing: Boolean = false
)
