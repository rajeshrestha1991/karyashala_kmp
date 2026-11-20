package com.karyashala.erp.domain.auth.login.model

data class LoginData(
    val token: String,
    val role: String,
    val message: String?
)
