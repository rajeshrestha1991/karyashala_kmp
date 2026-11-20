package com.karyashala.erp.domain.upComingEvent.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingEvents.EventsResponseDto

interface EventRemoteRepository {
    suspend fun fetchEvents(): ERPResult<EventsResponseDto, DataError>
}