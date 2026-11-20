package com.karyashala.erp.domain.auth.login.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.auth.login.LoginResponseDto
import com.karyashala.model.network.DataError

interface UserRemoteRepository {

    suspend fun login(username: String, password: String?, biometricToken: String?): ERPResult<LoginResponseDto, DataError>
}