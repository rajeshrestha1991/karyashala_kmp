package com.karyashala.erp.dashboard.graph

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.karyashala.erp.ChatViewModel
import com.karyashala.erp.chat_list.ChatListScreen
import com.karyashala.erp.chat_room.ChatRoomScreen
import com.karyashala.erp.components.sharedViewModel.koinNavGraphViewModel
import com.karyashala.erp.dashboard.route.ChatGraphRoute
import com.karyashala.erp.dashboard.route.ChatRoute
import com.karyashala.model.chat.ChatTypeEnum

fun NavGraphBuilder.chatScreenBuilder(
    navController: NavHostController
) {
    navigation<ChatGraphRoute>(
        startDestination = ChatRoute.ChatList(chatType = ChatTypeEnum.EMPLOYEE)
    ) {
        composable<ChatRoute.ChatList> {
            val viewModel = navController.koinNavGraphViewModel<ChatViewModel, ChatGraphRoute>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val chatType: ChatTypeEnum = it.toRoute<ChatRoute.ChatList>().chatType

            LaunchedEffect(Unit) {
                viewModel.navigateToChatChannel.collect { json ->
                    navController.navigate(ChatRoute.ChatRoom(json))
                }
            }

            ChatListScreen(
                state = state,
                onAction = viewModel::onAction,
                onBackPressed = {
                    navController.popBackStack()
                },
                chatType = chatType
            )
        }


        composable<ChatRoute.ChatRoom> {
            val viewModel = navController.koinNavGraphViewModel<ChatViewModel, ChatGraphRoute>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val json = it.toRoute<ChatRoute.ChatRoom>().json
            ChatRoomScreen(
                chatJson = json,
                state = state,
                onAction = viewModel::onAction,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }

}
