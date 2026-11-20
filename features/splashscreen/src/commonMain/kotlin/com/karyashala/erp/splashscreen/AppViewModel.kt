package com.karyashala.erp.splashscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karyashala.erp.components.locale.erpAppLocale
import com.karyashala.erp.domain.app.usecase.FetchUserInfoUseCase
import com.karyashala.erp.res.theme.ThemeMode
import com.karyashala.erp.splashscreen.model.AppThemeAction
import com.karyashala.erp.splashscreen.model.AppThemeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    fetchUserThemeModeUseCase: FetchUserInfoUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(AppThemeState())

    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(5_000),
        initialValue = AppThemeState()
    )

    init {
        viewModelScope.launch {
            fetchUserThemeModeUseCase().collect { userInfo ->
                erpAppLocale = userInfo.langCode
                _state.update {
                    it.copy(
                        userThemeMode = ThemeMode.get(userInfo.userThemeMode)
                    )
                }
            }
        }
    }

    fun onAction(action: AppThemeAction) {

    }

}