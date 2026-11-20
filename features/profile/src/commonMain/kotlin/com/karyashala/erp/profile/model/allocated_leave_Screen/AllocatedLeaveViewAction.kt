package com.karyashala.erp.profile.model.allocated_leave_Screen

interface AllocatedLeaveViewAction {
    data object  OnFetchData : AllocatedLeaveViewAction
    data object OnRefresh: AllocatedLeaveViewAction
}