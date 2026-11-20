package com.karyashala.erp.domain.upComingWorkAnniversaries.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingWorkAnniversaries.UpComingWorkAnniversaryDetailDto

interface UpComingWorkAnniversaryRemoteRepository {
    suspend fun fetchUpComingWorkAnniversary(): ERPResult<UpComingWorkAnniversaryDetailDto, DataError>
}