package com.karyashala.erp.domain.leave.leaveSummary.mappper

import com.karyashala.erp.domain.leave.leaveSummary.model.LeaveSummaryData
import com.karyashala.model.leave.leaveSummary.LeaveSummaryResponseDto

fun LeaveSummaryResponseDto.toData(): LeaveSummaryData {
    return LeaveSummaryData(
        pendingCount = detail?.pendingCount ?: 0,
        approvedCount = detail?.approvedCount ?: 0,
        rejectedCount = detail?.rejectedCount ?: 0,
        remainingLeaveCount = detail?.remainingLeaveCount ?: 0.0
    )
}