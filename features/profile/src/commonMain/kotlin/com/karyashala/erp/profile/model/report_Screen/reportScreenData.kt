package com.karyashala.erp.profile.model.report_Screen


import com.karyashala.erp.res.SharedRes
import org.jetbrains.compose.resources.StringResource


enum class ReportType(val title: StringResource) {
    MonthlyAttendance(SharedRes.Strings.monthlyAttendance),
    AttendanceSummary(SharedRes.Strings.attendanceSummary);

    companion object Companion {
        private val typeMap =
            enumValues<ReportType>().associateBy { it.title }

        fun get(typeName: StringResource): ReportType =
            ReportType.typeMap[typeName] ?: MonthlyAttendance

        val list: List<ReportType>
            get() = ReportType.entries.toList().map { it }
    }
}
