package com.karyashala.erp.model.notification

interface NotificationAction {
    data object OnRefresh: NotificationAction
    data object OnPagination: NotificationAction
}