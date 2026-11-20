package com.karyashala.erp.components.date.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.karyashala.erp.date.data.CalendarMonth
import com.karyashala.erp.date.data.model.CalendarModel

@Composable
fun rememberDateRangePickerState(
    calendarModel: CalendarModel,
    initialDisplayMonth: CalendarMonth? = null,
): DatePickerStateImpl {

    return remember {
        DatePickerStateImpl(
            initialDisplayMonth = initialDisplayMonth,
            calendarModel = calendarModel
        )
    }

}