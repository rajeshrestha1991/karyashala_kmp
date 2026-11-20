package com.karyashala.erp.data.upComingBirthday

import com.karyashala.erp.domain.upComingBirthday.repository.UpComingBirthdayRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingBirthday.UserUpComingBirthdayDetailDto
import io.ktor.client.HttpClient

class KtorUpComingBirthdayRemoteRepository(
    private val httpClient: HttpClient
) : UpComingBirthdayRemoteRepository {
    override suspend fun fetchUpComingBirthday(): ERPResult<UserUpComingBirthdayDetailDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.UPCOMING_BIRTHDAY_END_POINT
            )
        }
    }

}