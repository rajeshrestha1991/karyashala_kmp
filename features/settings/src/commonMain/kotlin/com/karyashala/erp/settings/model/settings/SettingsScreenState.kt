package com.karyashala.erp.settings.model.settings

import com.karyashala.erp.res.theme.EPRLanguage
import com.karyashala.erp.res.theme.ThemeMode

data class SettingsScreenState(
    val isAvailable: Boolean = false,
    val items: List<SettingList> = SettingList.list,
    val biometricEnabled: Boolean = false,
    val themes: List<ThemeMode> = ThemeMode.list,
    val languages: List<EPRLanguage> = EPRLanguage.list,
    val showPrompt: Boolean =false
)
