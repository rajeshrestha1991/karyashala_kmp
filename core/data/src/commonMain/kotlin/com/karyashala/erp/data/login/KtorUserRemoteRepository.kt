package com.karyashala.erp.data.login

import com.karyashala.erp.components.device_info.getDeviceInfo
import com.karyashala.erp.domain.auth.login.repository.UserRemoteRepository
import com.karyashala.erp.logger.AppLogger
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.auth.login.LoginRequestDto
import com.karyashala.model.auth.login.LoginResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorUserRemoteRepository(
    private val httpClient: HttpClient
) : UserRemoteRepository {
    override suspend fun login(
        username: String,
        password: String?,
        biometricToken: String?
    ): ERPResult<LoginResponseDto, DataError> {
        val deviceInfo = getDeviceInfo()
        val request = LoginRequestDto(
            biometricToken = biometricToken,
            email = username,
            password = password,
            deviceInfo = deviceInfo
        )
        AppLogger.i(TAG, "login: api request $request")
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.LOGIN_END_POINT
            ) {
                setBody(request)
            }
        }
    }

    companion object {
        private const val TAG = "KtorUserRemoteRepository"

    }
}