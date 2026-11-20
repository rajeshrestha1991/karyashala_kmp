package com.karyashala.erp.domain.allocatedLeave.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.allocatedLeave.mapper.toData
import com.karyashala.erp.domain.allocatedLeave.model.AllocatedLeaveData
import com.karyashala.erp.domain.allocatedLeave.repository.AllocatedLeaveRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull


class AllocatedLeaveUseCase(
    private val allocatedLeaveRemoteRepository: AllocatedLeaveRemoteRepository,
    private val userDataRepository: UserDataRepository,
) {
    suspend operator fun invoke(): ERPResult<List<AllocatedLeaveData>, DataError> {
        val id = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return allocatedLeaveRemoteRepository.getAllocatedLeave(id).map {
            it.toData()
        }
    }
}
