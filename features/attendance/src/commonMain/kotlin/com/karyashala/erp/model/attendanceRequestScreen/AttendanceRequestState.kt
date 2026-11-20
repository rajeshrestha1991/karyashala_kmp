package com.karyashala.erp.model.attendanceRequestScreen

import com.karyashala.erp.components.date.DateData
import com.karyashala.erp.domain.attendance.clockStatusEnum.ClockStatus
import com.karyashala.model.attendance.attendanceRequest.AttendanceRequestData
import com.karyashala.model.leave.ui.AssigneeUi
import org.jetbrains.compose.resources.StringResource

data class AttendanceRequestState(
    val date: DateData? = null,
    val dateError: StringResource? = null,

    val clockInTime: String? = null,
    val clockInOutError: StringResource? = null,

    val clockOutTime: String? = null,
    val clockOutTimeError: StringResource? = null,

    val reason: String? = null,
    val reasonError: StringResource? = null,

    val isAssigneeLoading: Boolean = false,
    val isAssigneeFetchingError: Boolean = false,
    val assignee: AssigneeUi? = null,
    val assigneeList: List<AssigneeUi>? = emptyList(),
    val assigneeError: StringResource? = null,

    val isRequestingAttendance: Boolean = false,
    val radioOptions: List<ClockStatus> = ClockStatus.list,
    val selectedOption: ClockStatus = radioOptions.first(),
    val attendanceRequestData: AttendanceRequestData? = null
)

