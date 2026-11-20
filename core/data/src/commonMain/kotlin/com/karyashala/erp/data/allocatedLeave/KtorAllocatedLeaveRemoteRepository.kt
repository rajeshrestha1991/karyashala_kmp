package com.karyashala.erp.data.allocatedLeave

import com.karyashala.erp.domain.allocatedLeave.repository.AllocatedLeaveRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.allocatedLeave.AllocatedLeaveResponseDto
import com.karyashala.model.network.DataError

import io.ktor.client.HttpClient

class KtorAllocatedLeaveRemoteRepository(private val httpClient: HttpClient) :
    AllocatedLeaveRemoteRepository {
    override suspend fun getAllocatedLeave(id: Int): ERPResult<AllocatedLeaveResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.ALLOCATED_LEAVE_ENDPOINT+"/$id"
            )
        }
    }


}