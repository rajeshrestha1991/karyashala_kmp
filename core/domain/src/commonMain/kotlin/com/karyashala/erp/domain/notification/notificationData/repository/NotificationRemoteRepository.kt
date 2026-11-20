package com.karyashala.erp.domain.notification.notificationData.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.notification.notificationCount.NotificationCountResponseDto
import com.karyashala.model.notification.notificationData.NotificationsResponseDto
import com.karyashala.model.notification.unSeenNotificationCount.UnSeenNotificationCountDto

interface NotificationRemoteRepository {
    suspend fun getNotificationCount(): ERPResult<NotificationCountResponseDto, DataError>

    suspend fun getAllNotification(offset: Int): ERPResult<NotificationsResponseDto, DataError>

    suspend fun getAllUnseenNotification(): ERPResult<UnSeenNotificationCountDto, DataError>
}