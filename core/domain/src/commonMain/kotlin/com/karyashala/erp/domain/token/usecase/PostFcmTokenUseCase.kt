package com.karyashala.erp.domain.token.usecase

import com.karyashala.erp.components.device_info.getDeviceUniqueIdentifier
import com.karyashala.erp.datastore.token.repository.TokenRepository
import com.karyashala.erp.domain.token.mapper.toData
import com.karyashala.erp.domain.token.model.FcmTokenData
import com.karyashala.erp.domain.token.repository.FcmTokenRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull


class PostFcmTokenUseCase(
    private val fcmTokenRepository: FcmTokenRepository,
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(
    ): ERPResult<FcmTokenData, DataError> {

        val fcmToken = tokenRepository.token.firstOrNull()?.fcmToken ?: ""
        return fcmTokenRepository.postFcmToken(
            fcmToken = fcmToken,
            uid = getDeviceUniqueIdentifier()
        ).map {
            it.toData()
        }
    }
}