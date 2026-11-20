package com.karyashala.di

import com.karyashala.erp.data.change_password.KtorChangePasswordRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.changePassword.repository.ChangePasswordRemoteRepository
import com.karyashala.erp.domain.changePassword.usecase.ChangePasswordUseCase
import com.karyashala.erp.domain.form.PasswordValidateUseCase
import com.karyashala.erp.settings.ChangePasswordViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class ChangePasswordModule {

    @Factory(binds = [ChangePasswordRemoteRepository::class])
    fun changePasswordRepository(httpClient: HttpClient) =
        KtorChangePasswordRemoteRepository(httpClient)

    @Factory
    fun changePasswordUseCase(
        changePasswordRemoteRepository: ChangePasswordRemoteRepository,
        userDataRepository: UserDataRepository
    ) = ChangePasswordUseCase(
        changePasswordRemoteRepository = changePasswordRemoteRepository,
        userDataRepository = userDataRepository
    )


    @KoinViewModel
    fun getChangePasswordViewModel(
        passwordValidateUseCase: PasswordValidateUseCase,
        changePasswordUseCase: ChangePasswordUseCase
    ) = ChangePasswordViewModel(
        newPasswordValidateUseCase = passwordValidateUseCase,
        changePasswordUseCase = changePasswordUseCase
    )
}