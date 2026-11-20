package com.karyashala.erp.dashboard.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karyashala.erp.dashboard.route.AttendanceRoute
import com.karyashala.erp.dashboard.route.DashboardRoute
import com.karyashala.erp.dashboard.route.ProfileRoute
import com.karyashala.erp.profile.allocated_leave.AllocatedLeaveScreen
import com.karyashala.erp.profile.company_assets.CompanyAssetsScreen
import com.karyashala.erp.profile.document.DocumentScreen
import com.karyashala.erp.profile.edit_profile.EditProfileScreen
import com.karyashala.erp.profile.history.HistoryScreen
import com.karyashala.erp.profile.model.profile_screen.AccountList
import com.karyashala.erp.profile.model.profile_screen.GeneralList
import com.karyashala.erp.profile.profile_info.ProfileInfoScreen
import com.karyashala.erp.profile.profile_screen.ProfileScreen
import com.karyashala.erp.profile.report_screen.ReportScreen
import com.karyashala.erp.profile.time_and_attendance.TimeAndAttendanceScreen
import com.karyashala.erp.profile.webview.WebviewScreen


fun NavGraphBuilder.profileScreenBuilder(
    onLogout: () -> Unit,
    navController: NavHostController
) {
    composable<DashboardRoute.ProfileRoute> {
        ProfileScreen(
            onLogout = onLogout,
            onAccountClick = { item ->
                when (item) {
                    AccountList.Settings -> {
                        navController.navigate(ProfileRoute.SettingsRoute)
                    }

                    else -> {
                        navController.navigate(ProfileRoute.WebviewRoute(item.url))
                    }
                }
            },
            onGeneralClick = { item ->
                when (item) {
                    GeneralList.Profile -> {
                        navController.navigate(ProfileRoute.ProfileInfoScreenRoute)
                    }

                    GeneralList.AllocatedLeave -> {
                        navController.navigate(ProfileRoute.AllocatedLeaveScreenRoute)
                    }

                    GeneralList.TimeAndAttendance -> {
                        navController.navigate(ProfileRoute.TimeAndAttendanceScreenRoute)
                    }

                    GeneralList.Document -> {
                        navController.navigate(ProfileRoute.DocumentScreenRoute)
                    }

                    GeneralList.CompanyAssets -> {
                        navController.navigate(ProfileRoute.CompanyAssetsScreenRoute)
                    }

                    GeneralList.History -> {
                        navController.navigate(ProfileRoute.HistoryScreenRoute)
                    }

                    GeneralList.Report ->
                        navController.navigate(ProfileRoute.ReportScreenRoute)
                }
            }
        )
    }
    composable<ProfileRoute.ProfileInfoScreenRoute> {
        ProfileInfoScreen(
            onBackPressed = {
                navController.popBackStack()
            }, onGotoEditProfile = {
                navController.navigate(ProfileRoute.EditProfileRoute)
            }
        )
    }
    composable<ProfileRoute.EditProfileRoute> {
        EditProfileScreen(
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }
    composable<ProfileRoute.AllocatedLeaveScreenRoute> {
        AllocatedLeaveScreen(onBackPressed = {
            navController.popBackStack()
        })
    }
    composable<ProfileRoute.TimeAndAttendanceScreenRoute> {
        TimeAndAttendanceScreen(
            onBackPressed = {
                navController.popBackStack()
            },
            onGoToAttendanceRequestScreen = { date, clockStatus ->
                navController.navigate(
                    AttendanceRoute.AttendanceRequestScreen(
                        date = date,
                        clockStatus = clockStatus
                    )
                )
            }
        )
    }
    composable<ProfileRoute.DocumentScreenRoute> {
        DocumentScreen(onBackPressed = {
            navController.popBackStack()
        })
    }
    composable<ProfileRoute.CompanyAssetsScreenRoute> {
        CompanyAssetsScreen(onBackPressed = {
            navController.popBackStack()
        })
    }
    composable<ProfileRoute.HistoryScreenRoute> {
        HistoryScreen(onBackPressed = {
            navController.popBackStack()
        })
    }
    composable<ProfileRoute.ReportScreenRoute> {
        ReportScreen(onBackPressed = {
            navController.popBackStack()
        })
    }

    composable<ProfileRoute.WebviewRoute> {
        val url = it.toRoute<ProfileRoute.WebviewRoute>().url
        WebviewScreen(
            url = url,
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }

}
