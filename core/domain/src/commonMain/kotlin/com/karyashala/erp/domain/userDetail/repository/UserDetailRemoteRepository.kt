package com.karyashala.erp.domain.userDetail.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.userDetail.UpdateProfileResponseDto
import com.karyashala.model.userDetail.UpdateRequestUserDto
import com.karyashala.model.userDetail.UserDetailResponseDto

interface UserDetailRemoteRepository {
    suspend fun fetchUserDetail(): ERPResult<UserDetailResponseDto, DataError>
    suspend fun userDataUpdate(
        data: UpdateRequestUserDto
    ): ERPResult<UpdateProfileResponseDto, DataError>
}

