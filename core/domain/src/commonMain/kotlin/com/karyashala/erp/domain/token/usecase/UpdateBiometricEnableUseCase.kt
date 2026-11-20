package com.karyashala.erp.domain.token.usecase

import com.karyashala.erp.datastore.token.model.Token
import com.karyashala.erp.datastore.token.repository.TokenRepository

class UpdateBiometricEnableUseCase(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(token: Token) {
        tokenRepository.saveToken(token)

    }
}