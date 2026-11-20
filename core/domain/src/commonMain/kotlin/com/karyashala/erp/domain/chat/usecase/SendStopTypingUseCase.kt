package com.karyashala.erp.domain.chat.usecase

import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.chat.repository.ChatSocketRepository
import kotlinx.coroutines.flow.firstOrNull

class SendStopTypingUseCase(
    private val chatSocketRepository: ChatSocketRepository,
    private val userDataRepository: UserDataRepository
) {
    suspend operator fun invoke(chatId: String) {
        val fromUser = userDataRepository.userDataFlow.firstOrNull()?.fullName ?: ""
        chatSocketRepository.sendStopTyping(
            chatId = chatId,
            fromUser = fromUser
        )
    }
}