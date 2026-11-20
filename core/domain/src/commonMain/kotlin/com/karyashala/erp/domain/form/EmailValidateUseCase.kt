package com.karyashala.erp.domain.form

import com.karyashala.erp.components.textField.FormValidate
import com.karyashala.erp.components.textField.validate
import org.jetbrains.compose.resources.StringResource

class EmailValidateUseCase {

    operator fun invoke(email: String): StringResource? {
        return FormValidate.emailValidationRules.validate(email)
    }

}