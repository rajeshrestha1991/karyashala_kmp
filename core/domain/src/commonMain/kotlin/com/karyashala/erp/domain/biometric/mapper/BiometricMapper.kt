package com.karyashala.erp.domain.biometric.mapper

import com.karyashala.erp.domain.biometric.model.BiometricData
import com.karyashala.model.biometric.BiometricResponseDto

fun BiometricResponseDto.toData(): BiometricData{
    return BiometricData(
        message = message ?: ""
    )
}