package com.karyashala.erp.domain.chat.usecase

import com.karyashala.erp.domain.chat.repository.ChatSocketRepository

class DisconnectSocketUseCase(private val chatSocketRepository: ChatSocketRepository) {
    operator fun invoke() = chatSocketRepository.disconnect()
}