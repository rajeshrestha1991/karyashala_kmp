package com.karyashala.erp.data.notification

import com.karyashala.erp.domain.notification.notificationData.repository.NotificationRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.notification.notificationCount.NotificationCountResponseDto
import com.karyashala.model.notification.notificationData.NotificationsResponseDto
import com.karyashala.model.notification.unSeenNotificationCount.UnSeenNotificationCountDto
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter

class KtorNotificationRemoteRepository(
    private val httpClient: HttpClient
) : NotificationRemoteRepository{
    override suspend fun getNotificationCount(): ERPResult<NotificationCountResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.TOTAL_NOTIFICATION_COUNT_END_POINT
            )
        }
    }

    override suspend fun getAllNotification(
        offset: Int,
    ): ERPResult<NotificationsResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ALL_NOTIFICATION_END_POINT+"/10"
            ){
                parameter("offset", offset)
            }
        }
    }

    override suspend fun getAllUnseenNotification(): ERPResult<UnSeenNotificationCountDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.TOTAL_UNREAD_NOTIFICATION_COUNT_END_POINT
            )
        }
    }
}