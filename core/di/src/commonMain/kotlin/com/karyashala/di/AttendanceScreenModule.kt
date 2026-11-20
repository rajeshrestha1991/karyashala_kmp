package com.karyashala.di

import com.karyashala.erp.attendance.AttendanceViewModel
import com.karyashala.erp.attendanceRequestScreen.AttendanceRequestViewModel
import com.karyashala.erp.data.attendance.KtorAttendanceRemoteRepository
import com.karyashala.erp.data.leaveRequest.KtorLeaveRequestRemoteRepository
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.attendance.attendanceReport.repository.AttendanceRemoteRepository
import com.karyashala.erp.domain.attendance.attendanceRequest.useCase.AttendanceRequestUseCase
import com.karyashala.erp.domain.attendance.attendanceStatus.useCase.AttendanceStatusUseCase
import com.karyashala.erp.domain.attendance.attendanceSummary.useCase.AttendanceSummaryUseCase
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.leave.leaveAssignee.usecase.AssigneeUseCase
import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class AttendanceScreenModule {
    @Factory(binds = [AttendanceRemoteRepository::class])
    fun attendanceRemoteRepository(httpClient: HttpClient) =
        KtorAttendanceRemoteRepository(httpClient)

    @Factory
    fun attendanceStatusUseCase(attendanceRemoteRepository: AttendanceRemoteRepository): AttendanceStatusUseCase =
        AttendanceStatusUseCase(attendanceRemoteRepository = attendanceRemoteRepository)

    @Factory(binds = [LeaveRemoteRepository::class])
    fun leaveRemoteRepository(httpClient: HttpClient): LeaveRemoteRepository =
        KtorLeaveRequestRemoteRepository(httpClient)


    @Factory
    fun assigneeUseCase(
        leaveRemoteRepository: LeaveRemoteRepository
    ): AssigneeUseCase = AssigneeUseCase(
        leaveRemoteRepository = leaveRemoteRepository
    )

    @Factory
    fun attendanceSummaryUseCase(
        attendanceRemoteRepository: AttendanceRemoteRepository
    ): AttendanceSummaryUseCase = AttendanceSummaryUseCase(
        attendanceRemoteRepository = attendanceRemoteRepository
    )


    @Factory
    fun attendanceRequestUseCase(
        attendanceRemoteRepository : AttendanceRemoteRepository
    ): AttendanceRequestUseCase = AttendanceRequestUseCase(
        attendanceRemoteRepository = attendanceRemoteRepository
    )

    @KoinViewModel
    fun getAttendanceViewModel(
        attendanceStatusUseCase: AttendanceStatusUseCase,
        attendanceSummaryUseCase: AttendanceSummaryUseCase,
        calendarModel: CalendarModel,
    ): AttendanceViewModel = AttendanceViewModel(
        attendanceStatusUseCase = attendanceStatusUseCase,
        attendanceSummaryUseCase = attendanceSummaryUseCase,
        calendarModel= calendarModel,
    )

    @KoinViewModel
    fun getAttendanceRequestScreenViewModel(
        requiredValidationUseCase: RequiredValidationUseCase,
        attendanceRequestUseCase: AttendanceRequestUseCase,
        assigneeUseCase: AssigneeUseCase
    ): AttendanceRequestViewModel = AttendanceRequestViewModel(
        assigneeUseCase = assigneeUseCase,
        attendanceRequestUseCase = attendanceRequestUseCase,
        requiredValidationUseCase = requiredValidationUseCase
    )
}