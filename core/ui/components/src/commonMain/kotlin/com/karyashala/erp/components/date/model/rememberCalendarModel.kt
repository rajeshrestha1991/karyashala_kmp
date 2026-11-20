package com.karyashala.erp.components.date.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.date.data.model.CalendarModelImpl

@Composable
fun rememberCalendarModel(): CalendarModel {
    return remember { CalendarModelImpl() }
}