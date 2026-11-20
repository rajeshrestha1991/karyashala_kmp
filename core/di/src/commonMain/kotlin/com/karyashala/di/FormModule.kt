package com.karyashala.di

import com.karyashala.erp.domain.form.EmailValidateUseCase
import com.karyashala.erp.domain.form.PasswordValidateUseCase
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class FormModule {

    @Single
    fun emailValidateUseCase() = EmailValidateUseCase()

    @Single
    fun passwordValidateUseCase() = PasswordValidateUseCase()

    @Single
    fun requiredValidation() = RequiredValidationUseCase()
}