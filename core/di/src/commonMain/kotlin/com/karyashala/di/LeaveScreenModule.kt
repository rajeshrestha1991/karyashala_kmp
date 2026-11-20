package com.karyashala.di

import com.karyashala.erp.data.leaveRequest.KtorLeaveRequestRemoteRepository
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.leave.leaveAssignee.usecase.AssigneeUseCase
import com.karyashala.erp.domain.leave.leaveReport.useCase.LeaveReportUseCase
import com.karyashala.erp.domain.leave.leaveRequest.repository.LeaveRemoteRepository
import com.karyashala.erp.domain.leave.leaveRequest.usecase.LeaveRequestUseCase
import com.karyashala.erp.domain.leave.leaveSummary.useCase.LeaveSummaryUseCase
import com.karyashala.erp.domain.leave.leaveType.usecase.LeaveTypeUseCase
import com.karyashala.erp.leave.leave.LeaveScreenViewModel
import com.karyashala.erp.leave.leaveRequestPage.LeaveRequestScreenViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class LeaveScreenModule {

    @Factory(binds = [LeaveRemoteRepository::class])
    fun leaveRemoteRepository(httpClient: HttpClient) =
        KtorLeaveRequestRemoteRepository(httpClient)

    @Factory
    fun leaveTypeUseCase(
        leaveRemoteRepository: LeaveRemoteRepository
    ): LeaveTypeUseCase = LeaveTypeUseCase(
        leaveRemoteRepository = leaveRemoteRepository
    )

    @Factory
    fun leaveReportUseCase(
        leaveRemoteRepository: LeaveRemoteRepository
    ): LeaveReportUseCase = LeaveReportUseCase(
        leaveRemoteRepository = leaveRemoteRepository
    )


    @Factory
    fun leaveAssigneeUseCase(
        leaveRemoteRepository: LeaveRemoteRepository
    ): AssigneeUseCase = AssigneeUseCase(
        leaveRemoteRepository = leaveRemoteRepository
    )

    @Factory
    fun leaveRequestUseCase(leaveRemoteRepository: LeaveRemoteRepository): LeaveRequestUseCase =
        LeaveRequestUseCase(leaveRemoteRepository)

    @Factory
    fun leaveSummaryUseCase (
        leaveRemoteRepository: LeaveRemoteRepository
    ): LeaveSummaryUseCase = LeaveSummaryUseCase(
        leaveRemoteRepository = leaveRemoteRepository
    )

    @KoinViewModel
    fun getLeaveScreenViewModel(

        leaveReportUseCase: LeaveReportUseCase,
        leaveSummaryUseCase : LeaveSummaryUseCase,
        calendarModel: CalendarModel,
    ): LeaveScreenViewModel = LeaveScreenViewModel(
        leaveReportUseCase = leaveReportUseCase,
        leaveSummaryUseCase = leaveSummaryUseCase,
        calendarModel = calendarModel
    )

    @KoinViewModel
    fun getLeaveRequestViewModel(
        leaveRequestUseCase: LeaveRequestUseCase,
        requiredValidationUseCase: RequiredValidationUseCase,
        leaveAssigneeUseCase: AssigneeUseCase,
        leaveTypeUseCase: LeaveTypeUseCase
    ): LeaveRequestScreenViewModel =
        LeaveRequestScreenViewModel(
            leaveRequestUseCase = leaveRequestUseCase,
            requiredValidationUseCase = requiredValidationUseCase,
            leaveTypeUseCase = leaveTypeUseCase,
            assigneeUseCase = leaveAssigneeUseCase
        )
}