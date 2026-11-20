package com.karyashala.erp.model.viewAll

import com.karyashala.model.upComingBirthday.ui.ViewAllUi

data class ViewAllScreenState(
    val data : List<ViewAllUi>? = emptyList(),
    val title : String? = ""
)