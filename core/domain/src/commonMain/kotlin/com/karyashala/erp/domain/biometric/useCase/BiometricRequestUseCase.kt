package com.karyashala.erp.domain.biometric.useCase

import com.karyashala.erp.domain.biometric.mapper.toData
import com.karyashala.erp.domain.biometric.model.BiometricData
import com.karyashala.erp.domain.biometric.repository.BiometricRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class BiometricRequestUseCase(
    private val biometricRemoteRepository: BiometricRemoteRepository
) {
    suspend operator fun invoke(
        biometricToken: String,
        uid: String
    ): ERPResult<BiometricData, DataError> {
        return biometricRemoteRepository.biometricRequest(
            biometricToken = biometricToken,
            uid = uid
        ).map {
            it.toData()
        }
    }
}