package com.karyashala.erp.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.karyashala.erp.route.AppRoute
import com.karyashala.erp.splashscreen.OnBoardingScreen

fun NavGraphBuilder.onBoardingBuilder(navController: NavHostController) {
    composable<AppRoute.OnBoardingRoute> {
        OnBoardingScreen(onNavigateToLogin = {
            navController.navigate(AppRoute.LoginRoute) {
                popUpTo(AppRoute.OnBoardingRoute) { inclusive = true }
            }
        })
    }
}
