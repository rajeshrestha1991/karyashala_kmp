package com.karyashala.erp.domain.userDetail.usecase

import com.karyashala.erp.components.extractInitials
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.userDetail.mapper.toData
import com.karyashala.erp.domain.userDetail.mapper.toDetail
import com.karyashala.erp.domain.userDetail.model.UserDetailData
import com.karyashala.erp.domain.userDetail.repository.UserDetailRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.erp.networkhelper.onSuccess
import com.karyashala.model.network.DataError
import com.karyashala.model.user_data.UserData
import kotlinx.coroutines.flow.firstOrNull


class FetchUserDetailUseCase(
    private val userDetailRemoteRepository: UserDetailRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(force: Boolean = false): ERPResult<UserDetailData, DataError> {
        val userData = userDataRepository.userDataFlow.firstOrNull()

        return if (userData == null || force) {
            remoteFetch(userData)
        } else {
            ERPResult.Success(userData.toDetail())
        }
    }


    private suspend fun remoteFetch(userData: UserData?): ERPResult<UserDetailData, DataError> {
        return userDetailRemoteRepository.fetchUserDetail().map { it.toData() }
            .onSuccess { userDetail ->
                userDataRepository.saveUserData(
                    userData?.copy(
                        email = userDetail.email,
                        phoneNumber = userDetail.phoneNumber,
                        fullName = userDetail.fullName,
                        imageUrl = userDetail.userProfileUrl,
                        initials = userDetail.fullName.extractInitials(),
                        levelName = userDetail.levelName,
                        employeeId = userDetail.employeeId,
                        branchName = userDetail.branchName,
                        joinedDate = userDetail.joinedDate  ,
                        address = userDetail.address,
                        dateOfBirth = userDetail.dateOfBirth ,
                        gender = userDetail.gender,
                        nationality = userDetail.nationality,
                        maritalStatus = userDetail.maritalStatus,
                        guardianName = userDetail.guardianName,
                        guardianPhone = userDetail.guardianNumber,
                        pfNumber = userDetail.pfNumber,
                        panNumber = userDetail.panNumber,
                        isCompleteProfile = userDetail.isCompleteProfile,
                        citizenshipFrontImage = userDetail.citizenshipFrontImage ,
                        citizenshipBackImage = userDetail.citizenshipBackImage ,
                        nationalId = userDetail.nationalId ,
                        slcDocument = userDetail.slcDocument,
                        plusTwoImage = userDetail.plusTwoImage,
                        bachelorImage = userDetail.bachelorImage ,
                        masterImage = userDetail.masterImage ,
                        designation = userDetail.levelName,
                        experienceDocuments = userDetail.experienceDocuments
                    ) ?: UserData()
                )
            }

    }
}
