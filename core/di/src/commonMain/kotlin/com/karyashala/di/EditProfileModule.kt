package com.karyashala.di

import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailUseCase
import com.karyashala.erp.domain.userDetail.usecase.UpdateUserDetailUseCase
import com.karyashala.erp.profile.edit_profile.EditProfileViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module

@Module
class EditProfileModule {


    @KoinViewModel
    fun getEditProfileScreenViewModel(
        fetchUserDetailUseCase: FetchUserDetailUseCase,
        requiredValidationUseCase: RequiredValidationUseCase,
        updateUserDetailUseCase: UpdateUserDetailUseCase,
    ): EditProfileViewModel = EditProfileViewModel(
        fetchUserDetailUseCase = fetchUserDetailUseCase,
        requiredValidationUseCase = requiredValidationUseCase,
        updateUserDetailUseCase = updateUserDetailUseCase,
    )
}