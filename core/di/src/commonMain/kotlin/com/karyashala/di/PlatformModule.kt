package com.karyashala.di

import com.karyashala.erp.components.PlatformMessage
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
expect class PlatformModule() {

    @Single
    fun getPlatformMessage(): PlatformMessage

}