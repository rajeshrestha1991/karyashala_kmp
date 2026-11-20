package com.karyashala.erp.domain.upComingWorkAnniversaries.useCase

import com.karyashala.erp.domain.upComingWorkAnniversaries.mapper.toData
import com.karyashala.erp.domain.upComingWorkAnniversaries.model.UpComingWorkAnniversaryData
import com.karyashala.erp.domain.upComingWorkAnniversaries.repository.UpComingWorkAnniversaryRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class UpComingWorkAnniversaryUseCase(
    private val upComingWorkAnniversaryRemoteRepository: UpComingWorkAnniversaryRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<UpComingWorkAnniversaryData>, DataError> {
        return upComingWorkAnniversaryRemoteRepository.fetchUpComingWorkAnniversary().map {
            it.toData()
        }
    }
}