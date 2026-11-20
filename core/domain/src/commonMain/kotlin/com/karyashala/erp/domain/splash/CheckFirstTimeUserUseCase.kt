package com.karyashala.erp.domain.splash

import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import kotlinx.coroutines.flow.firstOrNull

class CheckFirstTimeUserUseCase(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke(): Boolean {
        return userInfoRepository.userInfo.firstOrNull()?.isFirstTime ?: true
    }
}