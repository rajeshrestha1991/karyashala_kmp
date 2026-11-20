package com.karyashala.erp.domain.token.mapper

import com.karyashala.erp.domain.token.model.FcmTokenData
import com.karyashala.model.fcmToken.FcmTokenResponseDto

fun FcmTokenResponseDto.toData(): FcmTokenData{
    return FcmTokenData(
        message = message ?: ""
    )
}
