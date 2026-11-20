package com.karyashala.erp.datastore.user_info.repository

import com.karyashala.erp.datastore.user_info.local.UserInfoDataStore
import com.karyashala.model.user_info.UserInfo
import kotlinx.coroutines.flow.Flow

class LocalUserInfoRepository(
    private val userInfoDataStore: UserInfoDataStore
) : UserInfoRepository {
    override val userInfo: Flow<UserInfo> = userInfoDataStore.userInfoFlow

    override suspend fun saveUserInfo(userInfo: UserInfo) {
        userInfoDataStore.update(
            userInfo = userInfo
        )
    }
}
