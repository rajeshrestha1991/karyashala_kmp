package com.karyashala.erp.profile.model.companyAssets

import com.karyashala.erp.domain.companyAssets.model.CompanyAssetsData

data class CompanyAssetsState(
    val isLoading: Boolean = false,
    val companyAssetsList: List<CompanyAssetsData> = emptyList(),
    val isRefreshing: Boolean = false,
)