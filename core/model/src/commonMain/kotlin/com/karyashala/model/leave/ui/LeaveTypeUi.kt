package com.karyashala.model.leave.ui


import kotlinx.serialization.Serializable

@Serializable
data class LeaveTypeUi(
    val name: String,
    val value: String
) {
    override fun toString(): String = name
}
