package com.karyashala.erp.dashboard.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karyashala.erp.attendance.AttendanceScreen
import com.karyashala.erp.attendanceRequestScreen.AttendanceRequestScreen
import com.karyashala.erp.dashboard.route.AttendanceRoute
import com.karyashala.erp.dashboard.route.DashboardRoute
import com.karyashala.erp.missedAttendanceScreen.MissedAttendanceScreen

fun NavGraphBuilder.attendanceScreenBuilder(
    navController: NavHostController,
    onGoToAttendanceRequestScreen: () -> Unit,
    onGoToMissedAttendanceScreen: () -> Unit
) {
    composable<DashboardRoute.AttendanceRoute> {
        val isApproved = it.toRoute<DashboardRoute.AttendanceRoute>().isApproved
        AttendanceScreen(
            isApproved = isApproved,
            navController = navController,
            onGoToAttendanceRequestScreen = onGoToAttendanceRequestScreen,
            onGoToMissedAttendanceScreen = onGoToMissedAttendanceScreen
        )
    }

    composable<AttendanceRoute.AttendanceRequestScreen> {
        val date: String? = it.toRoute<AttendanceRoute.AttendanceRequestScreen>().date
        val clockStatus: String? = it.toRoute<AttendanceRoute.AttendanceRequestScreen>().clockStatus
        AttendanceRequestScreen(
            navController = navController,
            onBackPressed = {
                navController.popBackStack()
            },
            date = date,
            clockStatus = clockStatus
        )
    }

    composable<AttendanceRoute.MissedAttendanceScreen>{
        MissedAttendanceScreen()
    }
}