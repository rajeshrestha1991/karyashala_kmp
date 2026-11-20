package com.karyashala.erp.dashboard.model

import com.karyashala.erp.dashboard.route.DashboardRoute

sealed interface DashboardScreenAction {
    data class OnChangeScreen(val route: DashboardRoute) : DashboardScreenAction
    
    data object Reset : DashboardScreenAction
}