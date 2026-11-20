package com.karyashala.erp.domain.upComingBirthday.usecase

import com.karyashala.erp.domain.upComingBirthday.mapper.toData
import com.karyashala.erp.domain.upComingBirthday.model.UpComingBirthdayData
import com.karyashala.erp.domain.upComingBirthday.repository.UpComingBirthdayRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class UpComingBirthdayUseCase(
    private val upComingBirthdayRemoteRepository: UpComingBirthdayRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<UpComingBirthdayData>, DataError> {
        return upComingBirthdayRemoteRepository.fetchUpComingBirthday().map {
            it.toData()
        }
    }
}