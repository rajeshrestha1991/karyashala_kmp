package com.karyashala.erp.model.notification

import com.karyashala.erp.components.paging.model.PagingListState
import com.karyashala.erp.domain.notification.notificationData.model.NotificationData

data class NotificationState(
    val notifications : List<NotificationData> = emptyList(),
    val notificationGrouped : Map<String,List<NotificationData>> = emptyMap(),
    val isNotificationLoading : Boolean = false,
    val isRefreshing: Boolean = false,
    val pagingState: PagingListState = PagingListState.Initial
)