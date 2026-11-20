package com.karyashala.erp.domain.changePassword.mapper

import com.karyashala.erp.domain.changePassword.model.ChangePasswordData
import com.karyashala.model.changePassword.ChangePasswordResponseDTO

fun ChangePasswordResponseDTO.toData(): ChangePasswordData {
    return ChangePasswordData(
        status = status ?: "",
        message = message,
        success = success ?: false,
    )
}