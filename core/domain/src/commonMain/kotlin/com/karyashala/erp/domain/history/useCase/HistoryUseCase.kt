package com.karyashala.erp.domain.history.useCase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.history.mapper.toData
import com.karyashala.erp.domain.history.model.HistoryData
import com.karyashala.erp.domain.history.repository.HistoryRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class HistoryUseCase(
    private val historyRemoteRepository: HistoryRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        bsMonth: Int,
        bsYear: Int
    ): ERPResult<List<HistoryData>, DataError> {
        val employeeId = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return historyRemoteRepository.getHistoryLeave(
            bsMonth = bsMonth,
            bsYear = bsYear,
            branchId = null,
            employeeId = employeeId,
            isSelf = "Y"
        ).map { it.toData()
        }
    }
}