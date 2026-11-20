package com.karyashala.erp.domain.notification.notificationData.useCase

import com.karyashala.erp.domain.notification.notificationData.mapper.toData
import com.karyashala.erp.domain.notification.notificationData.model.NotificationData
import com.karyashala.erp.domain.notification.notificationData.repository.NotificationRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class NotificationUseCase(
    private val notificationRemoteRepository: NotificationRemoteRepository,
) {
    suspend operator fun invoke(offset: Int): ERPResult<List<NotificationData>, DataError>{
        return notificationRemoteRepository.getAllNotification(offset = offset).map {
            it.toData()
        }
    }
}