package com.karyashala.erp.model.attendanceRequestScreen

import com.karyashala.erp.components.date.DateData
import com.karyashala.erp.domain.attendance.clockStatusEnum.ClockStatus
import com.karyashala.model.attendance.attendanceRequest.AttendanceRequestData
import com.karyashala.model.leave.ui.AssigneeUi

interface AttendanceRequestAction {
    data class OnAssigneeChange(val assignee: AssigneeUi) : AttendanceRequestAction
    data class OnDateChange(val date: DateData) : AttendanceRequestAction
    data class OnClockInTimeChange(val clockInTime: String) : AttendanceRequestAction
    data class OnClockOutTimeChange(val clockOutTime: String) : AttendanceRequestAction
    data class OnReasonChange(val reason: String) : AttendanceRequestAction

    data object OnSubmit : AttendanceRequestAction

    data class OnUpdateAttendanceRequestData(val data: AttendanceRequestData) :
        AttendanceRequestAction

    data class OnRadioOptionChange(val option: ClockStatus) : AttendanceRequestAction

    data class OnReceivedDataChange(val date: String, val clockStatus: String): AttendanceRequestAction

}