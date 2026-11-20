package com.karyashala.erp.domain.userDetail.mapper

import com.karyashala.erp.components.date.DateData
import com.karyashala.erp.components.extractInitials
import com.karyashala.erp.domain.userDetail.model.UserDetailData
import com.karyashala.erp.domain.userDetail.model.UserUpdateData
import com.karyashala.erp.domain.userDetail.ui.EditProfileUI
import com.karyashala.model.userDetail.UpdateProfileResponseDto
import com.karyashala.model.userDetail.UpdateRequestUserDto
import com.karyashala.model.userDetail.UserDetailResponseDto
import com.karyashala.model.user_data.UserData

fun UserDetailResponseDto.toData(): UserDetailData {
    return UserDetailData(
        email = detail?.email ?: "N/A",
        phoneNumber = detail?.employeeDetails?.phoneNumber ?: "N/A",
        userProfileUrl = detail?.imageUrl ?: "",
        fullName = detail?.fullName ?: "",
        levelName = detail?.levelName ?: "",
        employeeId = detail?.employeeId ?: 0,
        address = detail?.employeeDetails?.address ?: "N/A",
        branchName = detail?.employeeDetails?.user?.branch?.branchName ?: "",
        dateOfBirth = detail?.employeeDetails?.dateOfBirth?.split("T")[0] ?: "",
        gender = detail?.employeeDetails?.gender ?: "N/A",
        joinedDate = detail?.employeeDetails?.joinedDate?.split("T")[0] ?: "",
        nationality = detail?.employeeDetails?.country ?: "N/A",
        maritalStatus = detail?.employeeDetails?.maritalStatus ?: "N/A",
        guardianName = detail?.employeeDetails?.guardianName ?: "",
        guardianNumber = detail?.employeeDetails?.guardianNumber ?: "",
        initials = detail?.fullName?.extractInitials() ?: "",
        isCompleteProfile = if (detail?.isCompleteProfile == "Y") true else false,
        bloodGroup = detail?.employeeDetails?.bloodGroup ?: "",
        designation = detail?.designation ?: "",
        panNumber = detail?.employeeDetails?.panNumber ?: "",
        pfNumber = detail?.employeeDetails?.pfNumber ?: "",
        bachelorImage = detail?.employeeDetails?.bachelorImageUrl?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        branchId = detail?.employeeDetails?.user?.branch?.id ?: 0,
        citizenshipBackImage = detail?.employeeDetails?.citizenshipBackImage?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        citizenshipFrontImage = detail?.employeeDetails?.citizenshipFrontImage?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        departmentId = detail?.departmentId ?: 0,
        designationId = detail?.designationId ?: 0,
        employeeType = detail?.employeeType ?: "",
        enableImageAttendance = detail?.employeeDetails?.enableImageAttendance ?: "",
        enableManualAttendance = !(detail?.employeeDetails?.enableManualAttendance ?: "").equals(
            "n",
            ignoreCase = true
        ),
        experienceDocuments = detail?.employeeDetails?.experienceDocumentsUrl?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        imageUrl = detail?.imageUrl,
        levelId = detail?.levelId ?: 0,
        mapId = detail?.employeeDetails?.mapId ?: 0,
        masterImage = detail?.employeeDetails?.masterImageUrl?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        nationalId = detail?.employeeDetails?.nationalIdImage?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        panImage = detail?.employeeDetails?.panImage?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        password = "",
        plusTwoImage = detail?.employeeDetails?.plusTwoImage?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        profileId = detail?.profileId ?: detail?.employeeDetails?.profileId ?: 0,
        slcDocument = detail?.employeeDetails?.slcDocumentUrl?.let {
            "https://karyashalaerp.com/erp-images/${it}"
        },
        roles = detail?.roles ?: emptyList()
    )
}

fun UserData.toDetail(): UserDetailData {
    return UserDetailData(
        email = email,
        phoneNumber = phoneNumber,
        fullName = fullName,
        levelName = levelName,
        employeeId = employeeId,
        address = address,
        dateOfBirth = dateOfBirth,
        gender = gender,
        joinedDate = joinedDate,
        nationality = nationality,
        maritalStatus = maritalStatus,
        guardianName = guardianName,
        guardianNumber = guardianPhone,
        initials = initials,
        isCompleteProfile = isCompleteProfile,
        bloodGroup = bloodGroup,
        designation = designation,
        employeeType = employeeTypes,
        panNumber = panNumber,
        pfNumber = pfNumber,
        branchName = branchName,
        bachelorImage = bachelorImage,
        branchId = branchId,
        citizenshipBackImage = citizenshipBackImage,
        citizenshipFrontImage = citizenshipFrontImage,
        departmentId = departmentId,
        designationId = designationId,
        enableImageAttendance = enableImageAttendance,
        enableManualAttendance = enableManualAttendance,
        experienceDocuments = experienceDocuments,
        imageUrl = imageUrl,
        levelId = levelId,
        mapId = mapId,
        masterImage = masterImage,
        nationalId = nationalId,
        panImage = panImage,
        password = password,
        plusTwoImage = plusTwoImage,
        profileId = profileId,
        slcDocument = slcDocument,
        userProfileUrl = userProfileUrl,
        roles = roles ?: emptyList()
    )
}

fun UserDetailData.toUI(): EditProfileUI {
    return EditProfileUI(
        fullName = fullName,
        email = email,
        levelName = levelName,
        phoneNumber = phoneNumber,
        employeeId = employeeId,
        branchName = branchName,
        address = address,
        joinedDate = if (joinedDate.isNotBlank()) DateData.fromDisplayAD(joinedDate) else null,
        maritalStatus = maritalStatus,
        gender = gender,
        dateOfBirth = if (dateOfBirth.isNotBlank()) DateData.fromDisplayAD(dateOfBirth) else null,
        bloodGroup = bloodGroup,
        guardianName = guardianName,
        guardianPhone = guardianNumber,
        designation = designation,
        employeeTypes = employeeType,
        panNumber = panNumber,
        pfNumber = pfNumber,
        initials = initials,
        imageUrl = imageUrl,

    )
}

fun EditProfileUI.toDomain(): UpdateRequestUserDto {
    return UpdateRequestUserDto(
        joinedDate = joinedDate?.displayValueAD,
        id = employeeId,
        startDate = dateOfBirth?.displayValueAD,
        guardianName = guardianName,
        guardianNumber = guardianPhone,
        bloodGroup = bloodGroup,
        employeeType = employeeTypes,
        panNumber = panNumber,
        pfNumber = pfNumber,
    )
}

fun UpdateProfileResponseDto.toData(): UserUpdateData {
    return UserUpdateData(
        message = message ?: ""
    )
}


