package com.karyashala.erp.settings.model.settings

import com.karyashala.erp.res.theme.EPRLanguage
import com.karyashala.erp.res.theme.ThemeMode

sealed interface SettingsScreenAction {
    data class OnBiometricStatusChange(val enable: Boolean) : SettingsScreenAction
    data class OnThemeSelected(val theme: ThemeMode) : SettingsScreenAction
    data class OnLanguageSelected(val language: EPRLanguage) : SettingsScreenAction
    data class OnIsAvailableCheck(val isAvailable: Boolean) : SettingsScreenAction
}