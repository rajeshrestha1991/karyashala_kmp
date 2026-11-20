package com.karyashala.erp.domain.reportScreen.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.reportScreen.ReportSummaryResponseDTO

interface ReportRemoteRepository {
    suspend fun getReportSummary(
        bsMonth: Int?,
        bsYear: Int?,
        branchId: String?,
        employeeId: Int?,
        isSelf: String?
    ): ERPResult<ReportSummaryResponseDTO, DataError>
}