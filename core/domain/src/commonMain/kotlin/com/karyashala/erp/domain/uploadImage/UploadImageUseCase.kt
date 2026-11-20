package com.karyashala.erp.domain.uploadImage

import com.karyashala.erp.datastore.user_data.repository.LocalUserDataRepository
import com.karyashala.erp.domain.imageUpload.ImageUploadRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.erp.networkhelper.onSuccess
import com.karyashala.model.network.DataError
import com.karyashala.model.uploadImage.ImageUpdateDocumentType
import com.karyashala.model.user_data.UserData
import kotlinx.coroutines.flow.firstOrNull

class UploadImageUseCase(
    private val imageUploadRepository: ImageUploadRepository,
    private val userDataRepository: LocalUserDataRepository

) {

    suspend operator fun invoke(
        filePath: String,
        imageName: String,
        onProgress: (Int) -> Unit,
        type: String
    ): ERPResult<UploadImageData, DataError> {
        val employeeId = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return imageUploadRepository.uploadImage(
            filePath = filePath,
            imageName = imageName,
            onProgress = onProgress,
            employeeId = employeeId,
            type = type
        ).onSuccess {
            //this path is stored in db so we need the same path to store in the local
            val filePath = it.data?.fileNames?.firstOrNull()

            //local userData
            val userData = userDataRepository.userDataFlow.firstOrNull() ?: UserData()

            //only update if file path is not null
            filePath?.let {
                when(type){
                    ImageUpdateDocumentType.PROFILE_IMAGE.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            imageUrl = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.CITIZENSHIP_FRONT.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            citizenshipFrontImage = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.CITIZENSHIP_BACK.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            citizenshipBackImage = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.NATIONAL_ID.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            nationalId = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.SLC_MARKSHEET.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            slcDocument = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.PLUS_TWO_IMAGE.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            plusTwoImage = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.BACHELOR.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            bachelorImage = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.MASTER.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            masterImage = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                    ImageUpdateDocumentType.EXPERIENCE_DOCUMENT.key ->{
                        userDataRepository.saveUserData(userData.copy(
                            experienceDocuments = "https://karyashalaerp.com/erp-images/${filePath}"
                        ))
                    }
                }
            }
        }
            .map {
            UploadImageData(
                a = it.message,
                imageName = it.data?.fileNames?.firstOrNull()
            )
        }
    }
}