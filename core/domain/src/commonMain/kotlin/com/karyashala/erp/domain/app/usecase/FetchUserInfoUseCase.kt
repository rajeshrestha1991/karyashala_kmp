package com.karyashala.erp.domain.app.usecase

import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import com.karyashala.model.user_info.UserInfo
import kotlinx.coroutines.flow.Flow

class FetchUserInfoUseCase(
    private val userInfoRepository: UserInfoRepository
) {
    operator fun invoke(): Flow<UserInfo> {
        return userInfoRepository.userInfo
    }
}