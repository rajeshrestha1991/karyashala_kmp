package com.karyashala.di

import com.karyashala.erp.dashboard.DashboardViewModel
import com.karyashala.erp.data.firebase.KtorFcmTokenRemoteRepository
import com.karyashala.erp.data.userDetail.KtorUserDetailRemoteRepository
import com.karyashala.erp.datastore.token.repository.TokenRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.token.repository.FcmTokenRepository
import com.karyashala.erp.domain.token.usecase.PostFcmTokenUseCase
import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.domain.userDetail.usecase.FetchUserDetailUseCase
import com.karyashala.model.AuthState
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class DashboardScreenModule {

    @Factory(binds = [UserDetailRemoteRepository::class])
    fun userDetailRemoteRepository(httpClient: HttpClient) =
        KtorUserDetailRemoteRepository(httpClient)

    @Factory(binds = [FcmTokenRepository::class])
    fun fcmTokenRepository(httpClient: HttpClient) =
        KtorFcmTokenRemoteRepository(httpClient)

    @Factory
    fun postFcmTokenUseCase(
        fcmTokenRepository: FcmTokenRepository,
        tokenRepository: TokenRepository
    ): PostFcmTokenUseCase = PostFcmTokenUseCase(
        fcmTokenRepository = fcmTokenRepository,
        tokenRepository=tokenRepository
    )

    @Factory
    fun userDetailUseCase(
        userDetailRemoteRepository: UserDetailRemoteRepository,
        userDataRepository: UserDataRepository
    ): FetchUserDetailUseCase =
        FetchUserDetailUseCase(
            userDetailRemoteRepository,
            userDataRepository
        )


    @KoinViewModel
    fun getDashboardViewModel(
        authState: AuthState,
        postFcmTokenUseCase: PostFcmTokenUseCase,
    ) = DashboardViewModel(
        authState = authState,
        postFcmTokenUseCase = postFcmTokenUseCase,
    )

}