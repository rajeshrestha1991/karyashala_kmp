package com.karyashala.erp.data.change_password

import com.karyashala.erp.domain.changePassword.repository.ChangePasswordRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint.CHANGE_PASSWORD_END_POINT
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.changePassword.ChangePasswordRequestDTO
import com.karyashala.model.changePassword.ChangePasswordResponseDTO
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorChangePasswordRemoteRepository(
    private val httpClient: HttpClient
) : ChangePasswordRemoteRepository {

    override suspend fun changePassword(
        email: String,
        newPassword: String,
        confirmPassword: String
    ): ERPResult<ChangePasswordResponseDTO, DataError> {
        val requestDto = ChangePasswordRequestDTO(
            email = email,
            password = newPassword,
            confirmPassword = confirmPassword
        )
        return safeCall {
            httpClient.post(
                endPoint = CHANGE_PASSWORD_END_POINT
            ) {
                setBody(
                    requestDto
                )
            }
        }
    }
}