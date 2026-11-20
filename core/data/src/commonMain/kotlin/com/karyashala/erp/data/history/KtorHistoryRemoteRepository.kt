package com.karyashala.erp.data.history

import com.karyashala.erp.domain.history.repository.HistoryRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.history.HistoryRequestDTO
import com.karyashala.model.history.HistoryResponseDTO
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorHistoryRemoteRepository(private val httpClient: HttpClient):
    HistoryRemoteRepository{
    override suspend fun getHistoryLeave(
        bsMonth: Int?,
        bsYear: Int?,
        branchId: String?,
        employeeId: Int?,
        isSelf: String?
    ): ERPResult<HistoryResponseDTO, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.HISTORY_END_POINT
            ){
                setBody(HistoryRequestDTO(
                    bsMonth = bsMonth,
                    bsYear = bsYear,
                    branchId = branchId,
                    employeeId = employeeId,
                    isSelf = isSelf
                ))
            }
        }
    }

}