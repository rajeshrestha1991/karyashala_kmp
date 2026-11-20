package com.karyashala.erp.domain.token.usecase

import com.karyashala.erp.datastore.token.model.Token
import com.karyashala.erp.datastore.token.repository.TokenRepository
import kotlinx.coroutines.flow.Flow

class FetchTokenAllValueUseCase(
    private val tokenRepository: TokenRepository
) {
    operator fun invoke(): Flow<Token> {
        return tokenRepository.token
    }
}