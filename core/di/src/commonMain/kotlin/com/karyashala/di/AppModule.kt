package com.karyashala.di


import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import com.karyashala.erp.domain.app.usecase.FetchUserInfoUseCase
import com.karyashala.erp.splashscreen.AppViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class AppModule {
    @Factory
    fun fetchUserThemeModeUseCase(
        userInfoRepository: UserInfoRepository
    ) = FetchUserInfoUseCase(userInfoRepository = userInfoRepository)


    @KoinViewModel
    fun appThemeViewModel(fetchUserThemeModeUseCase: FetchUserInfoUseCase) =
        AppViewModel(fetchUserThemeModeUseCase = fetchUserThemeModeUseCase)
}