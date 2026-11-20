package com.karyashala.erp.domain.notification.notificationCount.useCase

import com.karyashala.erp.domain.notification.notificationCount.mapper.toData
import com.karyashala.erp.domain.notification.notificationCount.model.NotificationCountData
import com.karyashala.erp.domain.notification.notificationData.repository.NotificationRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class NotificationCountUseCase(
    private val notificationRemoteRepository: NotificationRemoteRepository,
) {
    suspend operator fun invoke(force: Boolean = false): ERPResult<NotificationCountData, DataError> {
        return notificationRemoteRepository.getNotificationCount().map {
            it.toData()
        }
    }
}