package com.karyashala.erp.data.upComingEvent

import com.karyashala.erp.domain.upComingEvent.repository.EventRemoteRepository
import com.karyashala.erp.networkhelper.BaseUrl
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.network.DataError
import com.karyashala.model.upComingEvents.EventsResponseDto
import io.ktor.client.HttpClient

class KtorEventRemoteRepository(
    private val httpClient: HttpClient
): EventRemoteRepository {
    override suspend fun fetchEvents(): ERPResult<EventsResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                baseUrl = BaseUrl.Generic,
                endPoint = EndPoint.UPCOMING_EVENT_END_POINT
            )
        }
    }
}