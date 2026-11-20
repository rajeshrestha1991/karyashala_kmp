package com.karyashala.di

import com.karyashala.erp.components.platform_utils.PlatformUtils
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class PlatformUtilsModule {
    @Single
    actual fun providePlatformUtils(): PlatformUtils {
        return PlatformUtils()
    }
}