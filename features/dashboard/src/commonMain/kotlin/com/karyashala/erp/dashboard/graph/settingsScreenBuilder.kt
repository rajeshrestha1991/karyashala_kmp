package com.karyashala.erp.dashboard.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.karyashala.erp.dashboard.route.ProfileRoute
import com.karyashala.erp.settings.ChangePasswordScreen
import com.karyashala.erp.settings.SettingScreen

fun NavGraphBuilder.settingsScreenBuilder(
    navController: NavHostController
) {
    composable<ProfileRoute.SettingsRoute> {
        SettingScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            navigateToChangePassword = {
                navController.navigate(ProfileRoute.ChangePasswordRoute)
            }
        )
    }
    composable<ProfileRoute.ChangePasswordRoute> {
        ChangePasswordScreen(onBackPressed = {
            navController.popBackStack()
        })
    }
}