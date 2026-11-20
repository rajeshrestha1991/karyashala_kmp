package com.karyashala.di

import com.karyashala.erp.crypto.Cryptography
import com.karyashala.erp.crypto.getPlatformCryptography
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class CryptographyModule {
    @Single
    actual fun getCryptography(): Cryptography {
        return getPlatformCryptography()
    }
}