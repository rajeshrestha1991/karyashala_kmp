package com.karyashala.erp.dashboard.model

import com.karyashala.erp.dashboard.route.DashboardRoute
import com.karyashala.erp.domain.userDetail.model.UserDetailData

data class DashboardScreenState(
    val currentScreen: DashboardRoute = DashboardRoute.HomeRoute,
    val screens: List<DashboardScreen> = DashboardScreens.dashboardScreens,
    val userDetail: UserDetailData? = null,
    val isLoading: Boolean = false,
    val sessionExpired: Boolean = false
)
