package com.karyashala.erp.domain.allocatedLeave.repository


import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.allocatedLeave.AllocatedLeaveResponseDto
import com.karyashala.model.network.DataError

interface AllocatedLeaveRemoteRepository {
    suspend fun getAllocatedLeave(
        id: Int
    ): ERPResult<AllocatedLeaveResponseDto, DataError>

}