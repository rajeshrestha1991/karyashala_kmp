package com.karyashala.di

import com.karyashala.erp.data.allocatedLeave.KtorAllocatedLeaveRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.allocatedLeave.repository.AllocatedLeaveRemoteRepository
import com.karyashala.erp.domain.allocatedLeave.usecase.AllocatedLeaveUseCase
import com.karyashala.erp.profile.allocated_leave.AllocatedLeaveScreenViewModel
import io.ktor.client.HttpClient
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class AllocatedLeaveModule {
    @Factory(binds = [AllocatedLeaveRemoteRepository::class])
    fun allocatedLeaveRemoteRepository(httpClient: HttpClient): AllocatedLeaveRemoteRepository =
        KtorAllocatedLeaveRemoteRepository(httpClient)

    @Factory
    fun allocatedLeaveUseCase(allocatedLeaveRemoteRepository: AllocatedLeaveRemoteRepository, userDataRepository: UserDataRepository): AllocatedLeaveUseCase =
        AllocatedLeaveUseCase(allocatedLeaveRemoteRepository = allocatedLeaveRemoteRepository, userDataRepository= userDataRepository)

    @Factory
    fun getAllocatedLeaveScreenViewModel(
        allocatedLeaveUseCase: AllocatedLeaveUseCase
    ): AllocatedLeaveScreenViewModel = AllocatedLeaveScreenViewModel(
        allocatedLeaveUseCase = allocatedLeaveUseCase
    )
}