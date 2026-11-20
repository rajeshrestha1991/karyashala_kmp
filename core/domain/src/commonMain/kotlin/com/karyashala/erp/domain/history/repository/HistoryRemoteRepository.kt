package com.karyashala.erp.domain.history.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.history.HistoryResponseDTO
import com.karyashala.model.network.DataError

interface HistoryRemoteRepository {
    suspend fun getHistoryLeave(
        bsMonth: Int?,
        bsYear: Int?,
        branchId: String?,
        employeeId: Int?,
        isSelf: String?
    ): ERPResult<HistoryResponseDTO, DataError>
}