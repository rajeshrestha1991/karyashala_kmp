package com.karyashala.erp.domain.notification.unSeenNotificationCount.useCase

import com.karyashala.erp.domain.notification.notificationData.repository.NotificationRemoteRepository
import com.karyashala.erp.domain.notification.unSeenNotificationCount.mapper.toData
import com.karyashala.erp.domain.notification.unSeenNotificationCount.model.UnSeenNotificationCountData
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class UnseenNotificationUseCase(
    private val notificationRemoteRepository: NotificationRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<UnSeenNotificationCountData, DataError>{
        return notificationRemoteRepository.getAllUnseenNotification().map {
            it.toData()
        }
    }
}