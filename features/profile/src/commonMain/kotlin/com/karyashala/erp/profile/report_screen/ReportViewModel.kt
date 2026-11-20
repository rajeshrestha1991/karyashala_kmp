package com.karyashala.erp.profile.report_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karyashala.erp.date.data.model.CalendarModel
import com.karyashala.erp.domain.form.RequiredValidationUseCase
import com.karyashala.erp.domain.history.useCase.HistoryUseCase
import com.karyashala.erp.domain.reportScreen.useCase.ReportUseCase
import com.karyashala.erp.networkhelper.onSuccess
import com.karyashala.erp.profile.model.history_screen.toUI
import com.karyashala.erp.profile.model.report_Screen.ReportScreenState
import com.karyashala.erp.profile.model.report_Screen.ReportScreenViewAction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReportViewModel(
    private val requiredValidationUseCase: RequiredValidationUseCase,
    private val reportUseCase: ReportUseCase,
    private val historyUseCase: HistoryUseCase,
    private val calendarModel: CalendarModel

) : ViewModel() {

    private val todayMonth = calendarModel.today.month
    private val todayYear = calendarModel.today.year


    private val _state = MutableStateFlow(ReportScreenState())
    val state = _state
        .onStart {
            onFetchData(
                bsYear = todayYear,
                bsMonth = todayMonth,
                isRefreshing = false
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ReportScreenState()
        )

    private fun onFetchData(
        bsMonth : Int,
        bsYear: Int,
        isRefreshing: Boolean,
    ) = viewModelScope.launch {
        _state.update {
            it.copy(
                isLoading = true,
                isRefreshing = isRefreshing
            )
        }

        reportUseCase(
            bsMonth = bsMonth,
            bsYear = bsYear,

            ).onSuccess { data ->
            _state.update {
                it.copy(
                    isRefreshing = false,
                    isLoading = false,
                    reportListItems = _state.value.reportListItems.mapIndexed { index, reportItems ->
                        when (
                            index
                        ) {
                            0 -> reportItems.copy(
                                days = data[0].totalDays.toString()
                            )

                            1 -> reportItems.copy(
                                days = data[0].holidays.toString()
                            )

                            2 -> reportItems.copy(
                                days = data[0].totalWorkingDays.toString()
                            )

                            3 -> reportItems.copy(
                                days = data[0].totalWorkedDays.toString()
                            )

                            4 -> reportItems.copy(
                                days = data[0].totalLeaveTaken.toString()
                            )

                            5 -> reportItems.copy(
                                days = data[0].totalPresentDays.toString()
                            )

                            6 -> reportItems.copy(
                                days = data[0].totalAbsentDays.toString()
                            )

                            else -> reportItems
                        }
                    }
                )
            }
        }
        historyUseCase(
            bsMonth = bsMonth,
            bsYear = bsYear
        ).onSuccess { data ->

            _state.update {
                it.copy(
                    historySummaryList = data.map { item -> item.toUI() }
                )
            }

        }
    }

    fun onAction(action: ReportScreenViewAction) {
        when (action) {
            is ReportScreenViewAction.OnItemSelected -> {
                _state.update {
                    it.copy(
                        selectedTab = action.reportType
                    )
                }
            }

            is ReportScreenViewAction.YearField -> {
                _state.update {
                    it.copy(
                        year = action.year,
                        endYearError = null
                    )
                }
            }

            is ReportScreenViewAction.MonthField -> {
                _state.update {
                    it.copy(
                        monthDisplay = action.showMonth,
                        monthValue = action.month
                    )
                }
            }

            is ReportScreenViewAction.YearFieldError -> {
                _state.update {
                    it.copy(
                        endYearError = action.error
                    )
                }
            }

            is ReportScreenViewAction.MonthFieldError -> {
                _state.update {
                    it.copy(
                        endMonthError = action.error
                    )
                }
            }

            is ReportScreenViewAction.Submit -> {
                _state.update {
                    it.copy(
                        employeeId = action.employeeId
                    )
                }
                submit()
            }

            is ReportScreenViewAction.OnRefresh -> {
                onFetchData(
                    bsMonth = _state.value.monthValue ?: todayMonth,
                    bsYear = _state.value.year ?: todayYear,
                    isRefreshing = true
                )
            }
        }
    }

    private fun submit(

    ) = viewModelScope.launch {
        val monthPickerError = requiredValidationUseCase(state.value.monthDisplay)

        when {
            monthPickerError != null -> {
                _state.update {
                    it.copy(
                        endMonthError = monthPickerError
                    )
                }
            }

            else -> {
                _state.update {
                    it.copy(
                        endYearError = null
                    )
                }
            }
        }
        onFetchData(
            bsMonth = state.value.monthValue ?: todayMonth,
            bsYear = state.value.year ?: todayYear,
            isRefreshing = false
        )
    }


}