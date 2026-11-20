package com.karyashala.erp.data.upComingWorkAnniversary

import com.karyashala.erp.domain.upComingWorkAnniversaries.repository.UpComingWorkAnniversaryRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingWorkAnniversaries.UpComingWorkAnniversaryDetailDto
import io.ktor.client.HttpClient


class KtorUpComingWorkAnniversaryRemoteRepository(
    private val httpClient: HttpClient
) : UpComingWorkAnniversaryRemoteRepository {
    override suspend fun fetchUpComingWorkAnniversary(): ERPResult<UpComingWorkAnniversaryDetailDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.UPCOMING_WORK_ANNIVERSARY_END_POINT
            )
        }
    }
}