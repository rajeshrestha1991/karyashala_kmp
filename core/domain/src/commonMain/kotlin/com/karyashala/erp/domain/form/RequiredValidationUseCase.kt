package com.karyashala.erp.domain.form

import com.karyashala.erp.components.textField.FormValidate
import com.karyashala.erp.components.textField.validate
import org.jetbrains.compose.resources.StringResource

class RequiredValidationUseCase {
    operator fun invoke(value: String?): StringResource? {
        return FormValidate.requiredValidationRules.validate(value)
    }
}