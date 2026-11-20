package com.karyashala.erp.domain.settings.usecase

import com.karyashala.erp.datastore.user_info.repository.UserInfoRepository
import com.karyashala.model.user_info.UserInfo
import kotlinx.coroutines.flow.firstOrNull

class UpdateUserThemeUseCase(
    private val userInfoRepository: UserInfoRepository
) {
    suspend operator fun invoke(themeMode: Int) {
        val userInfo = userInfoRepository.userInfo.firstOrNull() ?: UserInfo()
        userInfoRepository.saveUserInfo(userInfo.copy(userThemeMode = themeMode))
    }
}