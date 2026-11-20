package com.karyashala.di

import com.karyashala.erp.data.reportScreen.KtorReportRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.history.useCase.HistoryUseCase
import com.karyashala.erp.domain.reportScreen.repository.ReportRemoteRepository
import com.karyashala.erp.domain.reportScreen.useCase.ReportUseCase
import com.karyashala.erp.profile.report_screen.ReportViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class ReportScreenModule {
    @Factory(binds = [ReportRemoteRepository::class])
    fun reportRemoteRepository(httpClient: HttpClient): ReportRemoteRepository =
        KtorReportRemoteRepository(httpClient)

    @Factory
    fun reportUseCase(reportRemoteRepository: ReportRemoteRepository, userDataRepository: UserDataRepository): ReportUseCase =
        ReportUseCase(reportRemoteRepository = reportRemoteRepository, userDataRepository = userDataRepository)

    @KoinViewModel
    fun getReportViewModel(
        reportUseCase: ReportUseCase,
        requiredValidationUseCase: RequiredValidationUseCase,
        historyUseCase: HistoryUseCase,
        calendarModel: CalendarModel
    ): ReportViewModel = ReportViewModel(
        reportUseCase = reportUseCase,
        requiredValidationUseCase = requiredValidationUseCase,
        historyUseCase = historyUseCase,
        calendarModel = calendarModel
    )

}