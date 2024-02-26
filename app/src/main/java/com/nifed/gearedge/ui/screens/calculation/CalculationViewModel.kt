package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nifed.gearedge.ui.screens.calculation.state.ButtonCalculationEvent
import com.nifed.gearedge.ui.screens.calculation.state.CalculationEvent
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState

// the const for  private fun calculateResult(size: String, feedRate: String): String
const val SCALE_RATE = 5.6
const val BASIC_FEED_RATE = 20.0
class CalculationViewModel: ViewModel() {
    var calculationState = mutableStateOf(CalculationState())
        private set

    fun onUiEvent(calculationEvent: CalculationEvent){
        when(calculationEvent){

            // TextField

            is CalculationEvent.SizeChanged -> {
                calculationState.value = calculationState.value.copy(
                    size = calculationEvent.inputValue
                )

            }
            is CalculationEvent.FeedRateChanged -> {
                calculationState.value = calculationState.value.copy(
                    feedRate = calculationEvent.inputValue
                )
            }


            // Time calculation

            is CalculationEvent.TimeChanged -> {
                calculationState.value = calculationState.value.copy(
                    time = calculateResult(calculationState.value.size, calculationState.value.feedRate)
                )
                return
            }


            // Buttons

            is ButtonCalculationEvent.IncreaseSize -> {
                calculationState.value = calculationState.value.copy(
                    size = shiftValue(calculationState.value.size, calculationEvent.value)
                )
            }
            is ButtonCalculationEvent.DecreaseSize -> {
                calculationState.value = calculationState.value.copy(
                    size = shiftValue(calculationState.value.size, calculationEvent.value)
                )
            }
            is ButtonCalculationEvent.IncreaseFeedRate -> {
                calculationState.value = calculationState.value.copy(
                    feedRate = shiftValue(calculationState.value.feedRate, calculationEvent.value)
                )
            }
            is ButtonCalculationEvent.DecreaseFeedRate -> {
                calculationState.value = calculationState.value.copy(
                    feedRate = shiftValue(calculationState.value.feedRate, calculationEvent.value)
                )
            }
        }

        this.onUiEvent(calculationEvent = CalculationEvent.TimeChanged(""))
    }




    private fun calculateResult(size: String, feedRate: String): String{
        val sizeDB: Double = convertStringToDouble(size)
        val feedRateDB: Double = convertStringToDouble(feedRate)


        val requiredTime = if(feedRateDB == 0.0) sizeDB / (BASIC_FEED_RATE * SCALE_RATE)
            else sizeDB / (feedRateDB * SCALE_RATE)
        return String.format("%.2f", requiredTime)
    }

    private fun convertStringToDouble(value: String): Double{
        return if(value.toDoubleOrNull() != null) value.toDouble() else 0.0
    }


    private fun shiftValue(value: String, delta: Double = 1.0): String{
        val valueDB: Double =
            if(value.toDoubleOrNull() != null)
                if (value.toDouble() > 0.0) value.toDouble() else 0.0
            else 0.0

        return String.format("%.2f", valueDB + delta)
    }

}