package com.karyashala.di

import com.karyashala.erp.ChatViewModel
import com.karyashala.erp.data.chat.IOChatSocketRepository
import com.karyashala.erp.data.chat.KtorChatRemoteRepository
import com.karyashala.erp.datastore.user_data.repository.UserDataRepository
import com.karyashala.erp.domain.chat.repository.ChatRemoteRepository
import com.karyashala.erp.domain.chat.repository.ChatSocketRepository
import com.karyashala.erp.domain.chat.usecase.ChatEmployListUseCase
import com.karyashala.erp.domain.chat.usecase.ConnectSocketUseCase
import com.karyashala.erp.domain.chat.usecase.DisconnectSocketUseCase
import com.karyashala.erp.domain.chat.usecase.FetchChatMessageUseCase
import com.karyashala.erp.domain.chat.usecase.JoinRoomUseCase
import com.karyashala.erp.domain.chat.usecase.ObserveSocketEventsUseCase
import com.karyashala.erp.domain.chat.usecase.SendMessageUseCase
import com.karyashala.erp.domain.chat.usecase.SendStopTypingUseCase
import com.karyashala.erp.domain.chat.usecase.SendTypingUseCase
import com.karyashala.erp.domain.support.useCase.SupportListFetchUseCase
import com.karyashala.erp.network.SocketManager
import io.ktor.client.HttpClient
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class ChatModule {
    @Factory(binds = [ChatRemoteRepository::class])
    fun getChatRemoteRepository(httpClient: HttpClient) = KtorChatRemoteRepository(httpClient)

    @Single
    fun getSocketManager() = SocketManager()

    @Single(binds = [ChatSocketRepository::class])
    fun getChatSocketRepository(socketManager: SocketManager) =
        IOChatSocketRepository(socketManager)

    @Factory
    fun getChatListUseCase(chatRemoteRepository: ChatRemoteRepository) =
        ChatEmployListUseCase(chatRemoteRepository)

    @Factory
    fun fetchChatMessageUseCase(
        chatRemoteRepository: ChatRemoteRepository,
        userDataRepository: UserDataRepository
    ) = FetchChatMessageUseCase(
        chatRemoteRepository = chatRemoteRepository,
        userDataRepository = userDataRepository
    )


    @Single
    fun getConnectSocketUseCase(
        chatSocketRepository: ChatSocketRepository
    ) = ConnectSocketUseCase(
        chatSocketRepository = chatSocketRepository
    )

    @Single
    fun getJoinRoomUseCase(
        chatSocketRepository: ChatSocketRepository,
        userDataRepository: UserDataRepository
    ) = JoinRoomUseCase(
        chatSocketRepository = chatSocketRepository,
        userDataRepository = userDataRepository
    )

    @Single
    fun getSendMessageUseCase(
        chatSocketRepository: ChatSocketRepository,
        userDataRepository: UserDataRepository
    ) = SendMessageUseCase(
        chatSocketRepository = chatSocketRepository,
        userDataRepository = userDataRepository
    )

    @Single
    fun getSendTypingUseCase(
        chatSocketRepository: ChatSocketRepository,
        userDataRepository: UserDataRepository
    ) = SendTypingUseCase(
        chatSocketRepository = chatSocketRepository,
        userDataRepository = userDataRepository
    )

    @Single
    fun getSendStopTypingUseCase(
        chatSocketRepository: ChatSocketRepository,
        userDataRepository: UserDataRepository
    ) = SendStopTypingUseCase(
        chatSocketRepository = chatSocketRepository,
        userDataRepository = userDataRepository
    )

    @Single
    fun getObserveSocketEventsUseCase(
        chatSocketRepository: ChatSocketRepository,
        userDataRepository: UserDataRepository
    ) =
        ObserveSocketEventsUseCase(
            chatSocketRepository = chatSocketRepository,
            userDataRepository = userDataRepository
        )

    @Single
    fun getDisconnectSocketUseCase(chatSocketRepository: ChatSocketRepository) =
        DisconnectSocketUseCase(chatSocketRepository)


//    @KoinViewModel
//    fun getChatListViewModel(chatListUseCase: ChatEmployListUseCase) =
//        ChatListViewModel(chatListUseCase)

    @KoinViewModel
    fun getChatViewModel(
        fetchChatMessageUseCase: FetchChatMessageUseCase,
        connectSocketUseCase: ConnectSocketUseCase,
        joinRoomUseCase: JoinRoomUseCase,
        sendMessageUseCase: SendMessageUseCase,
        sendTypingUseCase: SendTypingUseCase,
        sendStopTypingUseCase: SendStopTypingUseCase,
        observeSocketEventsUseCase: ObserveSocketEventsUseCase,
        disconnectSocketUseCase: DisconnectSocketUseCase,
        userDataRepository: UserDataRepository,
        chatEmployListUseCase: ChatEmployListUseCase,
        supportListFetchUseCase: SupportListFetchUseCase
    ): ChatViewModel = ChatViewModel(
        chatEmployListUseCase = chatEmployListUseCase,
        fetchChatMessageUseCase = fetchChatMessageUseCase,
        connectSocketUseCase = connectSocketUseCase,
        joinRoomUseCase = joinRoomUseCase,
        sendMessageUseCase = sendMessageUseCase,
        sendTypingUseCase = sendTypingUseCase,
        sendStopTypingUseCase = sendStopTypingUseCase,
        observeSocketEventsUseCase = observeSocketEventsUseCase,
        disconnectSocketUseCase = disconnectSocketUseCase,
        userDataRepository = userDataRepository,
        supportListFetchUseCase = supportListFetchUseCase
    )

//    @KoinViewModel
//    fun getChatRoomViewModel(
//        fetchChatMessageUseCase: FetchChatMessageUseCase,
//        connectSocketUseCase: ConnectSocketUseCase,
//        joinRoomUseCase: JoinRoomUseCase,
//        sendMessageUseCase: SendMessageUseCase,
//        sendTypingUseCase: SendTypingUseCase,
//        sendStopTypingUseCase: SendStopTypingUseCase,
//        observeSocketEventsUseCase: ObserveSocketEventsUseCase,
//        disconnectSocketUseCase: DisconnectSocketUseCase,
//        userDataRepository: UserDataRepository
//    ) = ChatRoomViewModel(
//        fetchChatMessageUseCase = fetchChatMessageUseCase,
//        connectSocketUseCase = connectSocketUseCase,
//        joinRoomUseCase = joinRoomUseCase,
//        sendMessageUseCase = sendMessageUseCase,
//        sendTypingUseCase = sendTypingUseCase,
//        sendStopTypingUseCase = sendStopTypingUseCase,
//        observeSocketEventsUseCase = observeSocketEventsUseCase,
//        disconnectSocketUseCase = disconnectSocketUseCase
//        userDataRepository = userDataRepository
//    )
}