package com.karyashala.di

import com.karyashala.erp.components.permissions.ProgressNotification
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class NotificationModule {

    @Factory
    fun getNotificationProgress(): ProgressNotification = ProgressNotification()
}


