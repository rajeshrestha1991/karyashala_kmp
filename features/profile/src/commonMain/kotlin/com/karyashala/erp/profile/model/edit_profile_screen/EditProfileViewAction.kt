package com.karyashala.erp.profile.model.edit_profile_screen

import com.karyashala.erp.components.date.DateData

interface EditProfileViewAction {
    data class OnBloodGroupChanged(val bloodGroup: String) : EditProfileViewAction
    data class OnGuardianNameChanged(val guardianName: String) : EditProfileViewAction
    data class OnGuardianPhoneChanged(val guardianPhone: String) : EditProfileViewAction
    data class PANNumberChanged(val panNumber: String) : EditProfileViewAction
    data class PFNumberChanged(val pfNumber: String) : EditProfileViewAction

    data class DateOfBirth(val date: DateData) : EditProfileViewAction
    data class JoinedDate(val date: DateData) : EditProfileViewAction
    data class EmployeeType(val employeeType: DropDownItems): EditProfileViewAction

    data class OnItemSelected(val index: Title) : EditProfileViewAction


    data class Submit(val employeeId: Int) : EditProfileViewAction




}