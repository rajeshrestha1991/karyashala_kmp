package com.karyashala.di

import com.karyashala.erp.data.userDetail.KtorUserDetailRemoteRepository
import com.karyashala.erp.datastore.user_data.local.UserDataDataStore
import com.karyashala.erp.datastore.user_data.repository.LocalUserDataRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.uploadImage.UploadImageUseCase
import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailUseCase
import com.karyashala.erp.domain.userDetail.usecase.UpdateUserDetailUseCase
import com.karyashala.erp.profile.document.DocumentScreenViewModel
import com.karyashala.erp.profile.profile_screen.ProfileScreenViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class ProfileScreenModule {

    @Factory(binds = [UserDetailRemoteRepository::class])
    fun userDetailRemoteRepository(httpClient: HttpClient) =
        KtorUserDetailRemoteRepository(httpClient)

    @Factory(binds = [UserDataRepository::class])
    fun userDataRepository(
        userDataDataStore: UserDataDataStore
    ): UserDataRepository =
        LocalUserDataRepository(
            userDataDataStore = userDataDataStore
        )

    @Factory
    fun userDetailUseCase(
        userDetailRemoteRepository: UserDetailRemoteRepository,
        userDataRepository: UserDataRepository
    ): FetchUserDetailUseCase =
        FetchUserDetailUseCase(
            userDetailRemoteRepository, userDataRepository = userDataRepository
        )


    @Factory
    fun updateUserDetailUseCase(
        userDetailRemoteRepository: UserDetailRemoteRepository,
        userDataRepository : UserDataRepository
    ): UpdateUserDetailUseCase=UpdateUserDetailUseCase(
        userDetailRemoteRepository = userDetailRemoteRepository,
        userDataRepository = userDataRepository
    )


    @KoinViewModel
    fun getProfileScreenViewModel(
        userDetailUseCase: FetchUserDetailUseCase,
        uploadImageUseCase: UploadImageUseCase,
    ): ProfileScreenViewModel = ProfileScreenViewModel(
        userDetailUseCase = userDetailUseCase,
        uploadImageUseCase = uploadImageUseCase,
    )


    @KoinViewModel
    fun getDocumentScreenViewModel(
        uploadImageUseCase: UploadImageUseCase,
        fetchUserDetailUseCase: FetchUserDetailUseCase
    ): DocumentScreenViewModel = DocumentScreenViewModel(
        fetchUserDetailUseCase = fetchUserDetailUseCase,
        uploadImageUseCase = uploadImageUseCase,
    )
}