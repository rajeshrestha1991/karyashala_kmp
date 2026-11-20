package com.karyashala.erp.datastore.token.repository

import com.karyashala.erp.datastore.token.model.Token
import kotlinx.coroutines.flow.Flow

interface TokenRepository {

    val token: Flow<Token>

    suspend fun saveToken(token: Token)

}