package com.karyashala.di

import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.attendance.attendanceReport.usecase.AttendanceUseCase
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.profile.time_and_attendance.TimeAndAttendanceViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module

@Module
class TimeAndAttendanceModule {

    @KoinViewModel
    fun getTimeAndAttendanceScreenViewModel(
        timeAndAttendanceUseCase: AttendanceUseCase,
        requiredValidationUseCase: RequiredValidationUseCase,
        calendarModel: CalendarModel
    ): TimeAndAttendanceViewModel = TimeAndAttendanceViewModel(
        timeAndAttendanceUseCase = timeAndAttendanceUseCase,
        requiredValidationUseCase = requiredValidationUseCase,
        calendarModel = calendarModel
    )
}
