package com.karyashala.erp.datastore.token.repository

import com.karyashala.erp.datastore.token.local.TokenDataStore
import com.karyashala.erp.datastore.token.model.Token
import kotlinx.coroutines.flow.Flow

class LocalTokenRepository(
    private val tokenDataStore: TokenDataStore
) : TokenRepository {
    override val token: Flow<Token> = tokenDataStore.tokenFlow
    override suspend fun saveToken(token: Token) {
        tokenDataStore.update(token = token)
    }

}