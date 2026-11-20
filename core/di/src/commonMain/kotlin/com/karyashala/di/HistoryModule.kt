package com.karyashala.di

import com.karyashala.erp.data.history.KtorHistoryRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.history.repository.HistoryRemoteRepository
import com.karyashala.erp.domain.history.useCase.HistoryUseCase
import com.karyashala.erp.profile.history.HistoryViewModel
import io.ktor.client.HttpClient
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class HistoryModule {
    @Factory(binds = [HistoryRemoteRepository::class])
    fun historyRemoteRepository(httpClient: HttpClient): HistoryRemoteRepository=
        KtorHistoryRemoteRepository(httpClient)

    @Factory
    fun historyUseCase(historyRemoteRepository: HistoryRemoteRepository, userDataRepository:UserDataRepository): HistoryUseCase =
        HistoryUseCase(historyRemoteRepository = historyRemoteRepository, userDataRepository = userDataRepository)

    @Factory
    fun getHistoryScreenViewModel(
        historyUseCase: HistoryUseCase,
        requiredValidationUseCase: RequiredValidationUseCase,
        calendarModel: CalendarModel
    ): HistoryViewModel = HistoryViewModel(
        historyUseCase = historyUseCase,
        requiredValidationUseCase = requiredValidationUseCase,
        calendarModel = calendarModel
    )

}