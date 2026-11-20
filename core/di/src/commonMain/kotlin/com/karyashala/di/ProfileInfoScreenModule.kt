package com.karyashala.di

import com.karyashala.erp.data.userDetail.KtorUserDetailRemoteRepository
import com.karyashala.erp.datastore.user_data.local.UserDataDataStore
import com.karyashala.erp.datastore.user_data.repository.LocalUserDataRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailUseCase
import com.karyashala.erp.profile.profile_info.ProfileInfoScreenViewModel
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class ProfileInfoScreenModule {

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


    @KoinViewModel
    fun getProfileInfoScreenViewModel(
        fetchUserDetailUseCase: FetchUserDetailUseCase
    ): ProfileInfoScreenViewModel = ProfileInfoScreenViewModel(
        fetchUserDetailUseCase = fetchUserDetailUseCase
    )


}