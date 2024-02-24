package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.runtime.mutableStateOf
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.nifed.gearedge.ui.screens.calculation.state.CalculationEvent
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState

class CalculationViewModel: ViewModel() {
    var calculationState = mutableStateOf(CalculationState())
        private set

    fun onUiEvent(calculationEvent: CalculationEvent){
        when(calculationEvent){
            is CalculationEvent.SizeChanged -> {
                calculationState.value = calculationState.value.copy(
                    size = calculationEvent.inputValue
                )
                this.onUiEvent(calculationEvent = CalculationEvent.TimeChanged(""))
            }
            is CalculationEvent.FeedRateChanged -> {
                calculationState.value = calculationState.value.copy(
                    feedRate = calculationEvent.inputValue
                )
                this.onUiEvent(calculationEvent = CalculationEvent.TimeChanged(""))
            }
            is CalculationEvent.TimeChanged -> {
                calculationState.value = calculationState.value.copy(
                    time = calculateResult(calculationState.value.size, calculationState.value.feedRate)
                )
            }


        }
    }


    private fun calculateResult(size: String, feedRate: String = "20.0"): String{
        val scaleRate: Double =5.6
        val sizeDB: Double = if(size.isNotBlank()) size.toDouble() else 0.0
        val feedRateDB: Double = if(feedRate.isNotBlank()) feedRate.toDouble() else 0.0


        val requiredTime = if(feedRateDB == 0.0) sizeDB / (20.0 * scaleRate)
            else sizeDB / (feedRateDB * scaleRate)
        return String.format("%.2f", requiredTime)
    }

}