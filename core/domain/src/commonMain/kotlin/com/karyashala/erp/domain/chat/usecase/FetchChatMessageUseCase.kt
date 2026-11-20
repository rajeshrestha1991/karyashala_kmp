package com.karyashala.erp.domain.chat.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.chat.mapper.toChatMessageData
import com.karyashala.erp.domain.chat.model.ChatMessageData
import com.karyashala.erp.domain.chat.repository.ChatRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError
import com.karyashala.model.user_data.UserData
import kotlinx.coroutines.flow.firstOrNull

class FetchChatMessageUseCase(
    private val chatRemoteRepository: ChatRemoteRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(
        chatId: String,
        page: Int,
        size: Int
    ): ERPResult<ChatMessageData, DataError> {
        val userData = userDataRepository.userDataFlow.firstOrNull() ?: UserData()
        return chatRemoteRepository.fetchChatMessage(
            chatId = chatId,
            page = page,
            size = size
        ).map { chatMessageResponseDto ->
            chatMessageResponseDto.toChatMessageData(userData)
        }
    }
}