package com.karyashala.erp.domain.reportScreen.useCase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.reportScreen.mapper.toData
import com.karyashala.erp.domain.reportScreen.model.ReportData
import com.karyashala.erp.domain.reportScreen.repository.ReportRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class ReportUseCase(
    private val reportRemoteRepository: ReportRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
   suspend operator fun invoke(
        bsMonth: Int,
        bsYear: Int
    ): ERPResult<List<ReportData>, DataError> {
       val employeeId = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
       return reportRemoteRepository.getReportSummary(
           bsMonth = bsMonth,
           bsYear = bsYear,
           branchId = null,
           employeeId = employeeId,
           isSelf = "Y"
       ).map { it.toData() }
   }
}