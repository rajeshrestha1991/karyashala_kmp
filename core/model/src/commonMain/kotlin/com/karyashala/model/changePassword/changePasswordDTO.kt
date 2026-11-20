package com.karyashala.model.changePassword

import kotlinx.serialization.Serializable

@Serializable
data class ChangePasswordRequestDTO(
    val email: String = "test@gmail.com",
    val password: String,
    val confirmPassword: String,

    )

@Serializable
data class ChangePasswordResponseDTO(
    val status: String? = null,
    val message: String? = null,
    val success: Boolean? = null
)
