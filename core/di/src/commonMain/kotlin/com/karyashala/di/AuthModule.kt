package com.karyashala.di

import com.karyashala.erp.data.login.KtorUserRemoteRepository
import com.karyashala.erp.datastore.token.repository.TokenRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.auth.login.repository.UserRemoteRepository
import com.karyashala.erp.domain.auth.login.usecase.ClearTokenUseCase
import com.karyashala.erp.domain.auth.login.usecase.LoginUseCase
import com.karyashala.erp.domain.form.EmailValidateUseCase
import com.karyashala.erp.domain.form.PasswordValidateUseCase
import com.karyashala.erp.domain.splash.UpdateFirstTimeCheckUseCase
import com.karyashala.erp.domain.token.usecase.FetchTokenAllValueUseCase
import com.karyashala.erp.domain.token.usecase.UpdateBiometricEnableUseCase
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailFlowUseCase
import com.karyashala.erp.login.LoginViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class AuthModule {


    @Factory(binds = [UserRemoteRepository::class])
    fun userRepository(httpClient: HttpClient) = KtorUserRemoteRepository(httpClient)

    @Factory
    fun loginUseCase(
        userRemoteRepository: UserRemoteRepository,
        tokenRepository: TokenRepository,
        userDataRepository: UserDataRepository
    ) = LoginUseCase(
        userRemoteRepository = userRemoteRepository,
        tokenRepository = tokenRepository,
        userDataRepository = userDataRepository
    )

    @Factory
    fun fetchUserDetailFlowUseCase(
        userDataRepository: UserDataRepository
    ): FetchUserDetailFlowUseCase=FetchUserDetailFlowUseCase(
        userDataRepository = userDataRepository
    )

    @Factory
    fun clearTokenUseCase(tokenRepository: TokenRepository) =
        ClearTokenUseCase(tokenRepository = tokenRepository)

    @KoinViewModel
    fun loginViewModel(
        loginUseCase: LoginUseCase,
        clearTokenUseCase: ClearTokenUseCase,
        emailValidateUseCase: EmailValidateUseCase,
        passwordValidateUseCase: PasswordValidateUseCase,
        updateFirstTimeCheckUseCase: UpdateFirstTimeCheckUseCase,
        fetchTokenAllValueUseCase: FetchTokenAllValueUseCase,
        fetchUserDetailFlowUseCase: FetchUserDetailFlowUseCase,
        updateBiometricEnableUseCase: UpdateBiometricEnableUseCase
    ) =
        LoginViewModel(
            loginUseCase = loginUseCase,
            clearTokenUseCase = clearTokenUseCase,
            emailValidateUseCase = emailValidateUseCase,
            passwordValidateUseCase = passwordValidateUseCase,
            updateFirstTimeCheckUseCase = updateFirstTimeCheckUseCase,
            fetchTokenAllValueUseCase = fetchTokenAllValueUseCase,
            fetchUserDetailFlowUseCase = fetchUserDetailFlowUseCase,
            updateBiometricEnableUseCase = updateBiometricEnableUseCase
        )

}