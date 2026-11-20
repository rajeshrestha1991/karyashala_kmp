package com.karyashala.erp.data.uploadImage

import com.karyashala.erp.components.getFileBytes
import com.karyashala.erp.domain.imageUpload.ImageUploadRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.erp.networkhelper.uploadImage
import com.karyashala.model.network.DataError
import com.karyashala.model.uploadImage.UploadImageResponseDto
import io.ktor.client.HttpClient

class KtorImageUploadRepository(
    private val httpClient: HttpClient
) : ImageUploadRepository {
    override suspend fun uploadImage(
        filePath: String,
        imageName: String,
        onProgress: (Int) -> Unit,
        employeeId: Int,
        type: String
    ): ERPResult<UploadImageResponseDto, DataError> {
        val bytes = getFileBytes(filePath)
        return safeCall {
            httpClient.uploadImage(
                endPoint = EndPoint.EMPLOYEE_IMAGE_UPLOAD_END_POINT,
                fileName = imageName,
                fileBytes = bytes,
                uri = filePath,
                onProgress = onProgress,
                type = type,
                employeeId = employeeId

            )
        }
    }

}