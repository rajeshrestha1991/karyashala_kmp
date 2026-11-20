package com.karyashala.erp.data.leaveRequest

import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.leave.leaveAssignee.LeaveAssigneeResponseDto
import com.karyashala.model.leave.leaveReport.LeaveReportRequestDto
import com.karyashala.model.leave.leaveReport.LeaveReportResponseDto
import com.karyashala.model.leave.leaveRequest.LeaveRequestDto
import com.karyashala.model.leave.leaveRequest.LeaveRequestResponseDto
import com.karyashala.model.leave.leaveSummary.LeaveSummaryResponseDto
import com.karyashala.model.leave.leaveType.LeaveTypeResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorLeaveRequestRemoteRepository(
    private val httpClient: HttpClient
) : LeaveRemoteRepository {
    override suspend fun fetchLeaveType(): ERPResult<LeaveTypeResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LEAVE_TYPE_END_POINT
            )
        }
    }

    override suspend fun fetchAssignee(): ERPResult<LeaveAssigneeResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LEAVE_ASSIGNEE_END_POINT
            )
        }
    }

    override suspend fun requestLeave(
        startDate: String,
        endDate: String,
        leaveDuration: String,
        leaveTypeId: Int,
        reason: String,
        assigneeId: Int
    ): ERPResult<LeaveRequestResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LEAVE_REQUEST_END_POINT
            ) {
                setBody(
                    LeaveRequestDto(
                        startDate = startDate,
                        endDate = endDate,
                        leaveDuration = leaveDuration,
                        leaveTypeId = leaveTypeId,
                        reason = reason,
                        assigneeId = assigneeId
                    )
                )
            }
        }
    }


    override suspend fun fetchLeaveReport(
        leaveStatus: String,
        fromDate: String,
        toDate: String
    ): ERPResult<LeaveReportResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LEAVE_STATUS_REPORT_ENDPOINT
            ) {
                setBody(
                    LeaveReportRequestDto(
                        fromDate = fromDate,
                        leaveStatus = leaveStatus,
                        toDate = toDate
                    )
                )
            }
        }
    }

    override suspend fun fetchLeaveSummary(): ERPResult<LeaveSummaryResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LEAVE_SUMMARY_END_POINT
            )
        }
    }
}