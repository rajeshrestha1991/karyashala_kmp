package com.karyashala.di

import com.karyashala.erp.data.companyAssets.KtorCompanyAssetsRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.companyAssets.repository.CompanyAssetsRemoteRepository
import com.karyashala.erp.domain.companyAssets.usecase.CompanyAssetsUseCase
import com.karyashala.erp.profile.company_assets.CompanyAssetsViewModel
import io.ktor.client.HttpClient
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class CompanyAssetsModule {
    @Factory(binds = [CompanyAssetsRemoteRepository::class])
    fun companyAssetsRemoteRepository(httpClient: HttpClient): CompanyAssetsRemoteRepository =
        KtorCompanyAssetsRemoteRepository(httpClient)

    @Factory
    fun companyAssetsUseCase(companyAssetsRemoteRepository: CompanyAssetsRemoteRepository, userDataRepository: UserDataRepository): CompanyAssetsUseCase =
        CompanyAssetsUseCase(
            companyAssetsRemoteRepository = companyAssetsRemoteRepository,
            userDataRepository = userDataRepository
        )

    @Factory
    fun getCompanyAssetsScreenViewModel(
        companyAssetsUseCase: CompanyAssetsUseCase
    ): CompanyAssetsViewModel = CompanyAssetsViewModel(
        companyAssetsUseCase = companyAssetsUseCase
    )
}