package com.karyashala.erp.domain.companyAssets.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.companyAssets.CompanyAssetResponseDto
import com.karyashala.model.network.DataError

interface CompanyAssetsRemoteRepository{
suspend fun getCompanyAssets(
    id: Int
): ERPResult<CompanyAssetResponseDto, DataError>

}