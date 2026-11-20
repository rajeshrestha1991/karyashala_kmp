package com.karyashala.erp.domain.chat.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.chat.repository.ChatSocketRepository
import kotlinx.coroutines.flow.firstOrNull

class SendMessageUseCase(
    private val chatSocketRepository: ChatSocketRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(chatId: String, message: String) {
        val fromUser = userDataRepository.userDataFlow.firstOrNull()?.fullName ?: ""
        chatSocketRepository.sendMessage(
            chatId = chatId,
            fromUser = fromUser,
            message = message
        )
    }
}