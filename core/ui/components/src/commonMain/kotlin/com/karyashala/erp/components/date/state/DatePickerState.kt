package com.karyashala.erp.components.date.state

import com.karyashala.erp.date.data.CalendarDate
import com.karyashala.erp.date.data.CalendarMonth


interface DatePickerState<T> {

    var selection: T?

    var displayedMonth: CalendarMonth

    fun select(date: CalendarDate)

    val selectedDate: CalendarDate?


}