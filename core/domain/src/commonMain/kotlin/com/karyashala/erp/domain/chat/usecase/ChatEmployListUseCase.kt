package com.karyashala.erp.domain.chat.usecase

import com.karyashala.erp.domain.chat.mapper.toChatItem
import com.karyashala.erp.domain.chat.model.EmployChatItem
import com.karyashala.erp.domain.chat.repository.ChatRemoteRepository
import com.karyashala.erp.networkhelper.ERPResult
import com.karyashala.erp.networkhelper.map
import com.karyashala.model.network.DataError

class ChatEmployListUseCase(
    private val chatRemoteRepository: ChatRemoteRepository
) {
    suspend operator fun invoke(): ERPResult<List<EmployChatItem>, DataError> {
        return chatRemoteRepository.fetchEmployList().map { employListResponseDto ->
            employListResponseDto.detail?.map { it.toChatItem() }?.sortedBy { it.sortOrder }
                ?: emptyList()
        }
    }
}