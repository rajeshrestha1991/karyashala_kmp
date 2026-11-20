package com.karyashala.di

import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import com.karyashala.erp.domain.splash.CheckFirstTimeUserUseCase
import com.karyashala.erp.domain.splash.UpdateFirstTimeCheckUseCase
import com.karyashala.erp.splashscreen.OnBoardingViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class SplashScreenModule {

    @KoinViewModel
    fun getSplashScreenViewModel(
        checkFirstTimeUserUseCase: CheckFirstTimeUserUseCase
    ) =
        OnBoardingViewModel(checkFirstTimeUserUseCase = checkFirstTimeUserUseCase)


    @Factory
    fun getFirstTimeUserUseCase(userInfoRepository: UserInfoRepository) =
        CheckFirstTimeUserUseCase(userInfoRepository = userInfoRepository)


    @Factory
    fun getUpdateFirstTimeUserUseCase(userInfoRepository: UserInfoRepository) =
        UpdateFirstTimeCheckUseCase(userInfoRepository = userInfoRepository)

}