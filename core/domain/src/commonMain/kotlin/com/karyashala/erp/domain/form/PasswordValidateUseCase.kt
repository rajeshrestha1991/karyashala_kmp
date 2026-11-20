package com.karyashala.erp.domain.form

import com.karyashala.erp.components.textField.FormValidate
import com.karyashala.erp.components.textField.validate
import org.jetbrains.compose.resources.StringResource

class PasswordValidateUseCase {
    operator fun invoke(password: String): StringResource? {
        return FormValidate.passwordValidationRules.validate(password)
    }
}