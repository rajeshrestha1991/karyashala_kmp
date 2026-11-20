package com.karyashala.model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorData(
    val message: String? = null
)