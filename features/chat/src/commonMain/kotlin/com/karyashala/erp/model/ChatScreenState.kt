package com.karyashala.erp.model

import com.karyashala.erp.domain.chat.mapper.toChatFormattedData
import com.karyashala.erp.domain.chat.mapper.toChatFormattedTime
import com.karyashala.erp.domain.chat.model.ChatMessageContent
import com.karyashala.erp.domain.chat.model.ChatMessageMetaData
import com.karyashala.erp.domain.chat.model.EmployChatItem
import com.karyashala.model.chat.ChatTypeEnum
import com.karyashala.model.chat.ChatUserData
import kotlin.random.Random
import kotlin.time.ExperimentalTime

data class ChatScreenState(
    val isEmployListLoading: Boolean = false,
    val chatList: List<EmployChatItem> = emptyList(),
    val chatListCache: List<EmployChatItem> = emptyList(),
    val query: String? = null,
    val error: String? = null,
    val showSearch: Boolean = false,
    val isEmployListRefreshing: Boolean = false,

    val isChatLoading: Boolean = false,
    val isTyping: Boolean = false,
    val chatUserData: ChatUserData? = null,
    val message: String = "",
    val messages: LinkedHashMap<String, List<ChatMessage>> = LinkedHashMap(),
    val metaData: ChatMetaData? = null,
    val isSocketConnected: Boolean = false,
    val isChatRefreshing: Boolean = false,

    val chatType: ChatTypeEnum = ChatTypeEnum.EMPLOYEE

)

data class ChatMessage @OptIn(ExperimentalTime::class) constructor(
    val id: Int = Random.nextInt(Int.MAX_VALUE),
    val message: String,
    val date: String,
    val time: String,
    val fromMe: Boolean
)

data class ChatMetaData(
    val currentPage: Int = 0,
    val totalPages: Int = 1
)

@OptIn(ExperimentalTime::class)
fun ChatMessageContent.toMessage(): ChatMessage {
    return ChatMessage(
        message = message,
        date = date.toChatFormattedData(),
        fromMe = fromMe,
        time = date.toChatFormattedTime()
    )
}

fun ChatMessageMetaData.toChatMetaData(): ChatMetaData {
    return ChatMetaData(
        currentPage = currentPage,
        totalPages = totalPages
    )
}
