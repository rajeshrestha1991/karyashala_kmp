package com.karyashala.erp.domain.support.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.support.SupportResponseDto

interface SupportListRemoteRepository {
    suspend fun getSupportList(): ERPResult<SupportResponseDto, DataError>
}