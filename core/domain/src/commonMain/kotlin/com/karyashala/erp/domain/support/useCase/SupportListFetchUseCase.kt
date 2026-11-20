package com.karyashala.erp.domain.support.useCase

import com.karyashala.erp.domain.support.mapper.toData
import com.karyashala.erp.domain.support.model.SupportListData
import com.karyashala.erp.domain.support.repository.SupportListRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class SupportListFetchUseCase(
    private val supportListRemoteRepository: SupportListRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<SupportListData>, DataError>{
        return supportListRemoteRepository.getSupportList().map {
            it.toData()
        }
    }
}