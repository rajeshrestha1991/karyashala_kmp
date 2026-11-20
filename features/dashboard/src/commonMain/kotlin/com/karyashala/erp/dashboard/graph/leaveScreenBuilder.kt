package com.karyashala.erp.dashboard.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.karyashala.erp.dashboard.route.DashboardRoute
import com.karyashala.erp.dashboard.route.LeaveRoute
import com.karyashala.erp.leave.leave.LeaveScreen
import com.karyashala.erp.leave.leaveRequestPage.LeaveRequestScreen


fun NavGraphBuilder.leaveScreenBuilder(
    navController: NavHostController,
    onGoToLeaveRequestPage: (String?) -> Unit,
    onGoToAllocatedLeaveScreen: () -> Unit
) {

    composable<DashboardRoute.LeaveRoute> {
        val isApproved = it.toRoute<DashboardRoute.LeaveRoute>().isApproved
        LeaveScreen(
            isApproved = isApproved,
            navController = navController,
            onGoToLeaveRequestPage = onGoToLeaveRequestPage,
            onGoToAllocatedLeaveScreen = onGoToAllocatedLeaveScreen
        )
    }
    composable<LeaveRoute.LeaveRequestPageRoute> {
        LeaveRequestScreen(
            navController = navController,
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }
}