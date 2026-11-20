package com.karyashala.erp.data.support

import com.karyashala.erp.domain.support.repository.SupportListRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.support.SupportResponseDto
import io.ktor.client.HttpClient

class KtorSupportListRepository(
    private val httpClient: HttpClient
): SupportListRemoteRepository {
    override suspend fun getSupportList(): ERPResult<SupportResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.SUPPORT_LIST_END_POINT
            )
        }
    }
}