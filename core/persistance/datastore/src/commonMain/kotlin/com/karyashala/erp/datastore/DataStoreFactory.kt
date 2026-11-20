package com.karyashala.erp.datastore

import com.karyashala.erp.datastore.token.local.TokenDataStore
import com.karyashala.erp.datastore.user_data.local.UserDataDataStore
import com.karyashala.erp.datastore.user_info.local.UserInfoDataStore

expect class DataStoreFactory() {

    fun getSystemPath(jsonPath: String): String

    fun getTokenDataStore(jsonPath: String): TokenDataStore

    fun getUserInfo(jsonPath: String): UserInfoDataStore

    fun getUserData(jsonPath: String): UserDataDataStore

}