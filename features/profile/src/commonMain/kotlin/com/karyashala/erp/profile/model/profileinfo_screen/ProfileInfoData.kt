package com.karyashala.erp.profile.model.profileinfo_screen


import com.karyashala.erp.res.SharedRes
import org.jetbrains.compose.resources.StringResource


enum class InfoList(val title: StringResource) {
    PersonalInfo(SharedRes.Strings.personal_info),
    EmergencyContact(SharedRes.Strings.emergency_contact);


    companion object {
        private val typeMap =
            enumValues<InfoList>().associateBy { it.title }

        fun get(typeName: StringResource): InfoList =
            InfoList.typeMap[typeName] ?: PersonalInfo

        val list: List<InfoList>
            get() = entries.toList().map { it }
    }
}


data class ProfileInfo(
    val name:StringResource,
    val value: String
)

