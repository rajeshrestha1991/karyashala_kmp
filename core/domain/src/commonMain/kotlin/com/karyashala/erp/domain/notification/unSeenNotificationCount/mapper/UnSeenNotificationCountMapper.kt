package com.karyashala.erp.domain.notification.unSeenNotificationCount.mapper

import com.karyashala.erp.domain.notification.unSeenNotificationCount.model.UnSeenNotificationCountData
import com.karyashala.model.notification.unSeenNotificationCount.UnSeenNotificationCountDto

fun UnSeenNotificationCountDto.toData(): UnSeenNotificationCountData{
    return UnSeenNotificationCountData(
        count = detail ?: 0
    )
}