package com.karyashala.erp.data.chat

import com.karyashala.erp.domain.chat.repository.ChatRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.EndPoint
import com.karyashala.erp.networkhelper.get
import com.karyashala.erp.networkhelper.safeCall
import com.karyashala.model.chat.list.ChatMessageResponseDto
import com.karyashala.model.chat.list.EmployListResponseDto
import com.karyashala.model.network.DataError
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter

class KtorChatRemoteRepository(
    private val httpClient: HttpClient
) : ChatRemoteRepository {
    override suspend fun fetchEmployList(): ERPResult<EmployListResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                endPoint = EndPoint.EMPLOY_LIST_ENDPOINT
            )
        }
    }

    override suspend fun fetchChatMessage(
        chatId: String,
        page: Int,
        size: Int
    ): ERPResult<ChatMessageResponseDto, DataError> {
        return safeCall {
            httpClient.get(
                endPoint = EndPoint.CHAT_MESSAGE_ENDPOINT
            ) {
                parameter("chatId", chatId)
                parameter("page", page)
                parameter("size", size)
            }
        }
    }
}