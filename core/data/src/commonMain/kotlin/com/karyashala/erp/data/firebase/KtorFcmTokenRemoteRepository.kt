package com.karyashala.erp.data.firebase

import com.karyashala.erp.domain.token.repository.FcmTokenRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.fcmToken.FcmTokenRequestDto
import com.karyashala.model.fcmToken.FcmTokenResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorFcmTokenRemoteRepository(
    private val httpClient: HttpClient
) : FcmTokenRepository {
    override suspend fun postFcmToken(
        uid: String,
        fcmToken: String
    ): ERPResult<FcmTokenResponseDto, DataError> {
        val fcmTokenRequest = FcmTokenRequestDto(
            deviceUniqueIdentifier = uid,
            fcmToken = fcmToken
        )
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.POST_FCM_TOKEN_END_POINT
            ) {
                setBody(fcmTokenRequest)
            }
        }
    }
}