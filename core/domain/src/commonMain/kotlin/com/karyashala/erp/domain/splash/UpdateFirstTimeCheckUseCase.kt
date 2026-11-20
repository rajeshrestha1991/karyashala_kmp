package com.karyashala.erp.domain.splash

import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import com.karyashala.model.user_info.UserInfo
import kotlinx.coroutines.flow.firstOrNull


class UpdateFirstTimeCheckUseCase(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke() {
        val user = userInfoRepository.userInfo.firstOrNull() ?: UserInfo()
        userInfoRepository.saveUserInfo(user.copy(isFirstTime = false))
    }
}

