package com.nifed.gearedge.ui.screens.calculation.state

sealed class CalculationEvent {
    data class SizeChanged(val inputValue: String): CalculationEvent()
    data class FeedRateChanged(val inputValue: String): CalculationEvent()
    data class TimeChanged(val inputValue: String) : CalculationEvent()

    //data class IncreaseSize(val value: Double): CalculationEvent()
}