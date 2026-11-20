package com.karyashala.erp.domain.token.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.fcmToken.FcmTokenResponseDto
import com.karyashala.model.network.DataError

interface FcmTokenRepository {
    suspend fun postFcmToken(
        uid: String,
        fcmToken: String
    ): ERPResult<FcmTokenResponseDto, DataError>
}