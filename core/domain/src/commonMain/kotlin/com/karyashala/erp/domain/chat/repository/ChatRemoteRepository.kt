package com.karyashala.erp.domain.chat.repository

import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.model.chat.list.ChatMessageResponseDto
import com.karyashala.model.chat.list.EmployListResponseDto
import com.karyashala.model.network.DataError

interface ChatRemoteRepository {

    suspend fun fetchEmployList(): ERPResult<EmployListResponseDto, DataError>

    suspend fun fetchChatMessage(
        chatId: String,
        page: Int,
        size: Int
    ): ERPResult<ChatMessageResponseDto, DataError>


}