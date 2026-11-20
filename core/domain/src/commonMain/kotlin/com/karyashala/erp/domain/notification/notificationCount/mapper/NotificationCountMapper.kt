package com.karyashala.erp.domain.notification.notificationCount.mapper

import com.karyashala.erp.domain.notification.notificationCount.model.NotificationCountData
import com.karyashala.model.notification.notificationCount.NotificationCountResponseDto

fun NotificationCountResponseDto.toData(): NotificationCountData {
    return NotificationCountData(
        count = detail ?: 0
    )
}

