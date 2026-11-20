package com.karyashala.erp.domain.changePassword.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.changePassword.ChangePasswordResponseDTO
import com.karyashala.model.network.DataError


interface ChangePasswordRemoteRepository {
    suspend fun changePassword(
        email: String,
        newPassword: String,
        confirmPassword: String,
    ): ERPResult<ChangePasswordResponseDTO, DataError>
}