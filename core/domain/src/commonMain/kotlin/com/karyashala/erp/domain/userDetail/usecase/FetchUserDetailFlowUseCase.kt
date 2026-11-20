package com.karyashala.erp.domain.userDetail.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.model.user_data.UserData
import kotlinx.coroutines.flow.Flow

class FetchUserDetailFlowUseCase(
    private val userDataRepository: UserDataRepository

) {
    operator fun invoke(): Flow<UserData>{
        return userDataRepository.userDataFlow
    }
}