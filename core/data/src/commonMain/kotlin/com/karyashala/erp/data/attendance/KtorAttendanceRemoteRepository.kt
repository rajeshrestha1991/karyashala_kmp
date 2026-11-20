package com.karyashala.erp.data.attendance

import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.attendance.attendanceCountReport.AttendanceCountReportResponseDto
import com.karyashala.model.attendance.attendanceReport.AttendanceReportRequestDto
import com.karyashala.model.attendance.attendanceReport.AttendanceResponseDto
import com.karyashala.model.attendance.attendanceRequest.AttendanceRequestDto
import com.karyashala.model.attendance.attendanceRequest.AttendanceRequestResponseDto
import com.karyashala.model.attendance.attendanceStatus.AttendanceStatusRequestDTO
import com.karyashala.model.attendance.attendanceStatus.AttendanceStatusResponseDTO
import com.karyashala.model.attendance.attendanceSummary.AttendanceSummaryResponseDto
import com.karyashala.model.attendance.doAttendance.DoAttendanceRequestDto
import com.karyashala.model.attendance.doAttendance.DoAttendanceResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody

class KtorAttendanceRemoteRepository(
    val httpClient: HttpClient
) : AttendanceRemoteRepository {

    override suspend fun fetchAttendance(
        dateFrom: String?,
        toDate: String?,
        attendanceStatus: String?,
        employeeId: Int?
    ): ERPResult<AttendanceResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.FETCH_ATTENDANCE_END_POINT
            ){
                setBody(AttendanceReportRequestDto(
                    fromDate = dateFrom,
                    toDate = toDate,
                    attendanceStatus = attendanceStatus,
                    employeeId = employeeId
                ))
            }
        }
    }

    override suspend fun fetchAttendanceStatus(
        attendanceStatus: String,
        employeeName: String,
        isSelf: String,
        fromDate: String,
        toDate: String
    ): ERPResult<AttendanceStatusResponseDTO, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ATTENDANCE_STATUS_REPORT_ENDPOINT,
            ) {
                setBody(AttendanceStatusRequestDTO(
                    attendanceStatus,
                    employeeName,
                    isSelf,
                    fromDate,
                    toDate
                ))
            }
        }
    }

    override suspend fun requestAttendance(
        assigneeId: Int,
        clockInTime: String?,
        clockOutTime: String?,
        date: String,
        remarks: String
    ): ERPResult<AttendanceRequestResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ATTENDANCE_REQUEST_END_POINT
            ){
                setBody(AttendanceRequestDto(
                    assigneeId = assigneeId,
                    clockInTime = clockInTime,
                    clockOutTime = clockOutTime,
                    date = date,
                    remarks = remarks
                ))
            }
        }
    }

    override suspend fun fetchAttendanceSummary(): ERPResult<AttendanceSummaryResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ATTENDANCE_SUMMARY_END_POINT
            )
        }
    }

    override suspend fun doAttendance(
        employeeId: Int,
        imageName: String,
        forDate: String
    ): ERPResult<DoAttendanceResponseDto, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.DO_ATTENDANCE_END_POINT
            ){
                setBody(DoAttendanceRequestDto(employeeId = employeeId, imageName = imageName, forDate = forDate))
            }
        }
    }

    override suspend fun attendanceCountReportFetch(
        employeeId: Int,
        toDate: String,
        fromDate: String
    ): ERPResult<AttendanceCountReportResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ATTENDANCE_COUNT_REPORT_ENT_POINT
            ) {
                parameter("employeeId", employeeId)
                parameter("toDate", toDate)
                parameter("fromDate", fromDate)
            }
        }
    }
}