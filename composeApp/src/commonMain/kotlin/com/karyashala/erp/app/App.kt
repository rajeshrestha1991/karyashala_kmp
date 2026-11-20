package com.karyashala.erp.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.karyashala.erp.components.AnimatedNavHost
import com.karyashala.erp.components.AppTheme
import com.karyashala.erp.components.locale.erpAppLocale
import com.karyashala.erp.components.statusBar.StatusBarView
import com.karyashala.erp.dashboard.graph.chatScreenBuilder
import com.karyashala.erp.dashboard.route.ChatRoute
import com.karyashala.erp.graph.dashboardScreenBuilder
import com.karyashala.erp.graph.loginScreenBuilder
import com.karyashala.erp.graph.onBoardingBuilder
import com.karyashala.erp.route.AppRoute
import com.karyashala.erp.splashscreen.AppViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import kotlin.time.ExperimentalTime

@Composable
@Preview
fun App(
    isFirstTime: Boolean,
    navigateToLeave: Boolean?,
    isApproved: Boolean?
) {

    val appViewModel: AppViewModel = koinViewModel<AppViewModel>()
    val state by appViewModel.state.collectAsStateWithLifecycle()



    AppTheme(
        selectedThemeMode = state.userThemeMode
    ) {
        StatusBarView()

        AppScreen(
            isFirstTime = isFirstTime,
            navigateToLeave = navigateToLeave,
            isApproved = isApproved
        )

    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun AppScreen(
    isFirstTime: Boolean,
    navigateToLeave: Boolean?,
    isApproved: Boolean?
) {

    val navController = rememberNavController()


    val startDestination = when {
        isFirstTime -> AppRoute.OnBoardingRoute
        navigateToLeave != null -> AppRoute.DashboardRoute(navigateToLeave, isApproved)
        else -> AppRoute.LoginRoute
    }

    key(erpAppLocale) {
        AnimatedNavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = startDestination
        ) {
            onBoardingBuilder(navController = navController)
            loginScreenBuilder(navController = navController)
            dashboardScreenBuilder(
                navController = navController,
                onChatClick = {chatType->
                    navController.navigate(ChatRoute.ChatList(chatType = chatType))
                },
                onBirthdayUser = { json ->
                    navController.navigate(ChatRoute.ChatRoom(json = json))
                }
            )

            chatScreenBuilder(
                navController = navController
            )
        }
    }
}
