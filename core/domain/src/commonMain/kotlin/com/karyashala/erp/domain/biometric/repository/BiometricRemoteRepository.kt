package com.karyashala.erp.domain.biometric.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.biometric.BiometricResponseDto
import com.karyashala.model.network.DataError

interface BiometricRemoteRepository {
    suspend fun biometricRequest(
        biometricToken: String,
        uid: String
    ): ERPResult<BiometricResponseDto, DataError>
}