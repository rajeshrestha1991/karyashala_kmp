package com.karyashala.erp.data.companyAssets

import com.karyashala.erp.domain.companyAssets.repository.CompanyAssetsRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.companyAssets.CompanyAssetResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient

class KtorCompanyAssetsRemoteRepository(
    private val httpClient: HttpClient):
    CompanyAssetsRemoteRepository {
    override suspend fun getCompanyAssets(id: Int): ERPResult<CompanyAssetResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.COMPANY_ASSETS_ENDPOINT+"/$id"
            )
        }
    }

}