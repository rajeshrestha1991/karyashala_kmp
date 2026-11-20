package com.karyashala.di

import com.karyashala.erp.components.PlatformMessage
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class PlatformModule {
    @Single
    actual fun getPlatformMessage(): PlatformMessage {
        return PlatformMessage()
    }
}