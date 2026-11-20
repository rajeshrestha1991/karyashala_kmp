package com.karyashala.model.notification.notificationCount

import kotlinx.serialization.Serializable

@Serializable
data class NotificationCountResponseDto(
    val status: String? = null,
    val message: String? = null,
    val detail: Int? = null,
    val success: Boolean? = null
)