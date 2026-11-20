package com.karyashala.erp.domain.companyAssets.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.companyAssets.mapper.toData
import com.karyashala.erp.domain.companyAssets.model.CompanyAssetsData
import com.karyashala.erp.domain.companyAssets.repository.CompanyAssetsRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import kotlinx.coroutines.flow.firstOrNull

class CompanyAssetsUseCase(
    private val companyAssetsRemoteRepository: CompanyAssetsRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(): ERPResult<List<CompanyAssetsData>, DataError>{
        val id = userDataRepository.userDataFlow.firstOrNull()?.employeeId ?: 0
        return companyAssetsRemoteRepository.getCompanyAssets(
            id
        ).map {
            it.toData()
        }
    }
}