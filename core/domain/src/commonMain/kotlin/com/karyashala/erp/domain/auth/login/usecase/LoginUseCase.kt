package com.karyashala.erp.domain.auth.login.usecase

import com.karyashala.erp.datastore.token.model.Token
import com.karyashala.erp.datastore.token.repository.TokenRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.auth.login.mapper.toData
import com.karyashala.erp.domain.auth.login.model.LoginData
import com.karyashala.erp.domain.auth.login.repository.UserRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.erp.networkhelper.onSuccess
import com.karyashala.model.network.DataError
import com.karyashala.model.user_data.UserData
import kotlinx.coroutines.flow.firstOrNull

class LoginUseCase(
    private val userRemoteRepository: UserRemoteRepository,
    private val tokenRepository: TokenRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        username: String,
        password: String? = null,
        biometricToken: String? = null
    ): ERPResult<LoginData, DataError> {
        return userRemoteRepository.login(username, password, biometricToken).map {
            it.toData()
        }.onSuccess { data ->
            val token = tokenRepository.token.firstOrNull() ?: Token()
            tokenRepository.saveToken(
                token.copy(
                    jwtToken = data.token
                )
            )

            val userData = userDataRepository.userDataFlow.firstOrNull() ?: UserData()
            userDataRepository.saveUserData(userData.copy(email = username))
        }
    }


}