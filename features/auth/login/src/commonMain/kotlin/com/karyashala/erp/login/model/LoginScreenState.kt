package com.karyashala.erp.login.model

import org.jetbrains.compose.resources.StringResource

data class LoginScreenState(
    val username: String = "",
    val password: String = "",
    val usernameError: StringResource? = null,
    val passwordError: StringResource? = null,
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val isBiometricEnabled : Boolean = false,

)
