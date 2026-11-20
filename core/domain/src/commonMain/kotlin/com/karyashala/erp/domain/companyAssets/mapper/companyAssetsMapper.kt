package com.karyashala.erp.domain.companyAssets.mapper

import com.karyashala.erp.domain.companyAssets.model.CompanyAssetsData
import com.karyashala.model.companyAssets.CompanyAssetResponseDto

fun CompanyAssetResponseDto.toData(): List<CompanyAssetsData>{
    return detail.assetDetails?.map {
        CompanyAssetsData(
            assetsId = it.id?: 0,
            assetsName = it.assetName?: "",
            assetsDescription = it.assetDescription?:"",
            dateInBs = it.dateInBs?: "" ,
            active = it.active?:""
        )
    } ?:emptyList() }