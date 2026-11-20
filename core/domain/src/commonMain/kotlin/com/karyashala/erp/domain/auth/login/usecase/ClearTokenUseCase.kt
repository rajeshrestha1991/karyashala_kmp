package com.karyashala.erp.domain.auth.login.usecase

import com.karyashala.erp.datastore.token.model.Token
import com.karyashala.erp.datastore.token.repository.TokenRepository
import kotlinx.coroutines.flow.firstOrNull

class ClearTokenUseCase(
    private val tokenRepository: TokenRepository
) {

    suspend operator fun invoke() {
        val token = tokenRepository.token.firstOrNull() ?: Token()
        tokenRepository.saveToken(token.copy(
            jwtToken = null
        ))
    }

}