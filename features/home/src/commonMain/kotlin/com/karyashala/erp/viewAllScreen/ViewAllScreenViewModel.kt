package com.karyashala.erp.viewAllScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karyashala.erp.model.viewAll.ViewAllScreenAction
import com.karyashala.erp.model.viewAll.ViewAllScreenState
import com.karyashala.model.upComingBirthday.ui.ViewAllUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json

class ViewAllScreenViewModel : ViewModel() {

    private val _state = MutableStateFlow(ViewAllScreenState())

    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ViewAllScreenState()
    )

    fun onAction(action: ViewAllScreenAction) {
        when (action) {
            is ViewAllScreenAction.OnJsonUpdate -> {
                val jsonData = Json.decodeFromString<List<ViewAllUi>>(action.json)
                _state.update {
                    it.copy(
                        data = jsonData
                    )
                }
            }
            is ViewAllScreenAction.OnTitleUpdate->{
                val title = Json.decodeFromString<String>(action.title)
                _state.update {
                    it.copy(
                        title = title
                    )
                }
            }
        }
    }
}