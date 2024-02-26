package com.nifed.gearedge.ui.screens.calculation.state

sealed class CalculationEvent {
    data class SizeChanged(val inputValue: String): CalculationEvent()
    data class FeedRateChanged(val inputValue: String): CalculationEvent()
    data class TimeChanged(val inputValue: String) : CalculationEvent()



}

// Buttons, recreate //TODO
sealed class ButtonCalculationEvent : CalculationEvent() {
    data class IncreaseSize(val value: Double) : CalculationEvent()
    data class DecreaseSize(val value: Double) : CalculationEvent()
    data class IncreaseFeedRate(val value: Double) : CalculationEvent()
    data class DecreaseFeedRate(val value: Double) : CalculationEvent()
}