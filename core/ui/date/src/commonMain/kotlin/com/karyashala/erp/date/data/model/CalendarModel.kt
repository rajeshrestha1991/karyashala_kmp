package com.karyashala.erp.date.data.model

import com.karyashala.erp.date.data.CalendarDate
import com.karyashala.erp.date.data.CalendarDay
import com.karyashala.erp.date.data.CalendarMonth

abstract class CalendarModel {
    abstract val today: CalendarDate

    //    abstract val weekdayNames: List<String>
    abstract fun numberOfDaysInMonth(): List<CalendarDay>

    abstract fun getPage(year: Int, month: Int): Int

    abstract fun getYearRange(): IntRange

    abstract fun getMonth(calendarDate: CalendarDate): CalendarMonth

    abstract fun getMonth(page: Int): CalendarMonth

    abstract fun getNumberOfMonths(): Int
}