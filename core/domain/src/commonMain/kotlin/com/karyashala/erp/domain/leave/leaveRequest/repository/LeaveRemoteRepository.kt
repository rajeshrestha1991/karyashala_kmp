package com.karyashala.erp.domain.leave.leaveRequest.repository


import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.leave.leaveAssignee.LeaveAssigneeResponseDto
import com.karyashala.model.leave.leaveReport.LeaveReportResponseDto
import com.karyashala.model.leave.leaveRequest.LeaveRequestResponseDto
import com.karyashala.model.leave.leaveSummary.LeaveSummaryResponseDto
import com.karyashala.model.leave.leaveType.LeaveTypeResponseDto
import com.karyashala.model.network.DataError

interface LeaveRemoteRepository {
    suspend fun fetchLeaveType(): ERPResult<LeaveTypeResponseDto, DataError>
    suspend fun fetchAssignee(): ERPResult<LeaveAssigneeResponseDto, DataError>

    suspend fun requestLeave(
        startDate: String,
        endDate: String,
        leaveDuration: String,
        leaveTypeId: Int,
        reason: String,
        assigneeId: Int
    ): ERPResult<LeaveRequestResponseDto, DataError>

    suspend fun fetchLeaveReport(
        leaveStatus: String,
        fromDate: String,
        toDate: String
    ): ERPResult<LeaveReportResponseDto, DataError>


    suspend fun fetchLeaveSummary(): ERPResult<LeaveSummaryResponseDto, DataError>

}