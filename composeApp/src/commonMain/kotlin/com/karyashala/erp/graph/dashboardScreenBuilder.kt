package com.karyashala.erp.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karyashala.erp.dashboard.DashboardScreen
import com.karyashala.erp.route.AppRoute
import com.karyashala.model.chat.ChatTypeEnum

fun NavGraphBuilder.dashboardScreenBuilder(
    navController: NavHostController,
    onChatClick: (chatType: ChatTypeEnum) -> Unit,
    onBirthdayUser: (json: String) -> Unit
) {
    composable<AppRoute.DashboardRoute> {
        val route = it.toRoute<AppRoute.DashboardRoute>()
        val navigateToLeave = route.navigateToLeave
        val isApproved = route.isApproved
        DashboardScreen(
            navigateToLeave = navigateToLeave,
            isApproved = isApproved,
            onLogout = {
                navController.navigate(AppRoute.LoginRoute) {
                    popUpTo(AppRoute.DashboardRoute()) { inclusive = true }
                }
            },
            onChatClick = onChatClick,
            onBirthdayUser = onBirthdayUser
        )
    }
}