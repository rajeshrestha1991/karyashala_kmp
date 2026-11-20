package com.karyashala.erp.dashboard.route

import kotlinx.serialization.Serializable

@Serializable
sealed interface LeaveRoute {
    @Serializable
    data object LeaveRequestPageRoute : LeaveRoute
}