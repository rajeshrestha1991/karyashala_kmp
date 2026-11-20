package com.karyashala.erp.components.date.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.karyashala.erp.date.data.CalendarDate
import com.karyashala.erp.date.data.CalendarMonth
import com.karyashala.erp.date.data.model.CalendarModel

@Stable
class DatePickerStateImpl(
    initialDisplayMonth: CalendarMonth?,
    calendarModel: CalendarModel
) : DatePickerState<CalendarDate> {
    var selectedItem: CalendarDate? by mutableStateOf(calendarModel.today)
    override val selectedDate: CalendarDate? = null
    override var selection: CalendarDate?
        get() {
            return selectedItem
        }
        set(value) {
            selectedItem = value
        }
    override var displayedMonth: CalendarMonth by mutableStateOf(
        initialDisplayMonth ?: calendarModel.getMonth(
            calendarModel.today
        )
    )

    override fun select(date: CalendarDate) {
        selectedItem = date
    }

}

