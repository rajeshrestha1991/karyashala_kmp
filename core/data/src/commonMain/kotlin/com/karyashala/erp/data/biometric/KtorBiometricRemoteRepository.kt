package com.karyashala.erp.data.biometric

import com.karyashala.erp.domain.biometric.repository.BiometricRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.biometric.BiometricRequestDto
import com.karyashala.model.biometric.BiometricResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorBiometricRemoteRepository(
    private val httpClient: HttpClient
) : BiometricRemoteRepository {
    override suspend fun biometricRequest(
        biometricToken: String,
        uid: String
    ): ERPResult<BiometricResponseDto, DataError> {
        val requestDto =
            BiometricRequestDto(biometricToken = biometricToken, deviceUniqueIdentifier = uid)
//        AppLogger.i(
//            tag = "KtorBiometricRemoteRepository",
//            message = "biometric request ${Json.encodeToString(requestDto)}"
//        )
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.BIOMETRIC_REQUEST_END_POINT
            ) {
                setBody(
                    requestDto
                )
            }
        }
    }
}