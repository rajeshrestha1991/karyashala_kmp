package com.karyashala.di

import com.karyashala.erp.data.uploadImage.KtorImageUploadRepository
import com.karyashala.erp.datastore.user_data.repository.LocalUserDataRepository
import com.karyashala.erp.domain.imageUpload.ImageUploadRepository
import com.karyashala.erp.domain.uploadImage.UploadImageUseCase
import io.ktor.client.HttpClient
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module

@Module
class UploadImageModule {

    @Factory(binds = [ImageUploadRepository::class])
    fun imageUploadRepository(httpClient: HttpClient): ImageUploadRepository =
        KtorImageUploadRepository(httpClient = httpClient)

    @Factory
    fun uploadImageUseCase(
        imageUploadRepository: ImageUploadRepository,
        userDataRepository: LocalUserDataRepository
    ): UploadImageUseCase = UploadImageUseCase(
        userDataRepository = userDataRepository,
        imageUploadRepository = imageUploadRepository)
}


