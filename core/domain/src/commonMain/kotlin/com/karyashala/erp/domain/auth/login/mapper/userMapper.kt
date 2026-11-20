package com.karyashala.erp.domain.auth.login.mapper

import com.karyashala.erp.domain.auth.login.model.LoginData
import com.karyashala.model.auth.login.LoginResponseDto


fun LoginResponseDto.toData(): LoginData {
    return LoginData(
        token = token ?: "",
        role = role ?: "",
        message = message
    )
}