package com.karyashala.erp.domain.imageUpload

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.uploadImage.UploadImageResponseDto

interface ImageUploadRepository {
    suspend fun uploadImage(
        filePath: String,
        imageName: String,
        onProgress: (Int) -> Unit,
        employeeId: Int,
        type: String
    ): ERPResult<UploadImageResponseDto, DataError>
}