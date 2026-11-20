package com.karyashala.erp.data.reportScreen

import com.karyashala.erp.domain.reportScreen.repository.ReportRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.post
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.reportScreen.ReportRequestDTO
import com.karyashala.model.reportScreen.ReportSummaryResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

class KtorReportRemoteRepository(private val httpClient: HttpClient) :
    ReportRemoteRepository {
    override suspend fun getReportSummary(
        bsMonth: Int?,
        bsYear: Int?,
        branchId: String?,
        employeeId: Int?,
        isSelf: String?
    ): ERPResult<ReportSummaryResponseDTO, DataError> {
        return safeCall {
            httpClient.post(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.REPORT_END_POINT
            ){
                setBody(ReportRequestDTO(
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