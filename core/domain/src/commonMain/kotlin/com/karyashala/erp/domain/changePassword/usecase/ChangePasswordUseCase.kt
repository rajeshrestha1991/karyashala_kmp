package com.karyashala.erp.domain.changePassword.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.changePassword.mapper.toData
import com.karyashala.erp.domain.changePassword.model.ChangePasswordData
import com.karyashala.erp.domain.changePassword.repository.ChangePasswordRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class ChangePasswordUseCase(
    private val changePasswordRemoteRepository: ChangePasswordRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        newPassword: String,
        confirmPassword: String,
    ): ERPResult<ChangePasswordData, DataError> {
        val email = userDataRepository.userDataFlow.firstOrNull()?.email ?: ""
        return changePasswordRemoteRepository
            .changePassword(
                email = email,
                newPassword = newPassword,
                confirmPassword = confirmPassword
            ).map { it.toData() }
    }

}