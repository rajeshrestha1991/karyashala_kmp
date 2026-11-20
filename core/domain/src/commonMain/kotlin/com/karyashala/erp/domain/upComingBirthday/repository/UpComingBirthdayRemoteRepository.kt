package com.karyashala.erp.domain.upComingBirthday.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingBirthday.UserUpComingBirthdayDetailDto

interface UpComingBirthdayRemoteRepository {
    suspend fun fetchUpComingBirthday(): ERPResult<UserUpComingBirthdayDetailDto, DataError>
}