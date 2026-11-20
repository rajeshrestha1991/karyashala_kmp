package com.karyashala.erp.profile.allocated_leave

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karyashala.erp.domain.allocatedLeave.usecase.AllocatedLeaveUseCase
import com.karyashala.erp.networkhelper.onSuccess
import com.karyashala.erp.profile.model.allocated_leave_Screen.AllocatedLeaveState
import com.karyashala.erp.profile.model.allocated_leave_Screen.AllocatedLeaveViewAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AllocatedLeaveScreenViewModel(
    private val allocatedLeaveUseCase: AllocatedLeaveUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(AllocatedLeaveState())
    val state = _state
        .onStart {
            onFetchData()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = AllocatedLeaveState()
        )

    fun onAction(action: AllocatedLeaveViewAction) {
        when (action) {
            is AllocatedLeaveViewAction.OnFetchData -> {
                onFetchData()
            }
            is AllocatedLeaveViewAction.OnRefresh->{
                refresh()
            }
        }

    }

    private fun onFetchData() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        allocatedLeaveUseCase(
        ).onSuccess { data ->
            _state.update {
                it.copy(
                    isLoading = false,
                    leaveSummaryList = data,
                    isRefreshing = false
                )
            }
        }

    }

    private fun refresh()=viewModelScope.launch {
        _state.update {
            it.copy(
                isRefreshing = true
            )
        }
        onFetchData()
    }

}