package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nifed.gearedge.ui.screens.calculation.state.CalculationEvent
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState

class CalculationViewModel: ViewModel() {
    var calculationState = mutableStateOf(CalculationState())
        private set

    fun onUiEvent(calculationEvent: CalculationEvent){
        when(calculationEvent){
            is CalculationEvent.SpeedChanged -> {
                calculationState.value = calculationState.value.copy(
                    speed = calculationEvent.inputValue
                )
            }
            is CalculationEvent.FeedRateChanged -> {
                calculationState.value = calculationState.value.copy(
                    feedRate = calculationEvent.inputValue
                )
            }
            is CalculationEvent.TimeChanged -> {
                calculationState.value = calculationState.value.copy(
                    time = calculationEvent.inputValue
                )
            }
        }
    }
}