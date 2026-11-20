package com.karyashala.erp.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.karyashala.erp.login.LoginScreen
import com.karyashala.erp.route.AppRoute

fun NavGraphBuilder.loginScreenBuilder(navController: NavHostController) {

    composable<AppRoute.LoginRoute> {
        LoginScreen(onNavigateToDashboard = {
            navController.navigate(AppRoute.DashboardRoute()) {
                popUpTo(AppRoute.LoginRoute) { inclusive = true }
            }
        })
    }
}