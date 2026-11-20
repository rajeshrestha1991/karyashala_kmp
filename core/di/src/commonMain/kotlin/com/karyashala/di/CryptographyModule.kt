package com.karyashala.di

import com.karyashala.erp.crypto.Cryptography
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
expect class CryptographyModule() {

    @Single
    fun getCryptography(): Cryptography
}