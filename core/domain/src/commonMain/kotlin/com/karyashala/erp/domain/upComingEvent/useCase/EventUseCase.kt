package com.karyashala.erp.domain.upComingEvent.useCase

import com.karyashala.erp.domain.upComingEvent.mapper.toData
import com.karyashala.erp.domain.upComingEvent.model.EventData
import com.karyashala.erp.domain.upComingEvent.repository.EventRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class EventUseCase(
    private val eventRemoteRepository: EventRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<EventData>, DataError>{
        return eventRemoteRepository.fetchEvents().map {
            it.toData()
        }
    }
}