package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nifed.gearedge.ui.screens.calculation.state.CalculationEvent
import com.nifed.gearedge.ui.theme.GearedgeTheme

@Composable
fun CalculationScreen(
    calculationViewModel: CalculationViewModel = viewModel()
) {
    val calculationState by remember {
        calculationViewModel.calculationState
    }
    CalculationInputs(
        calculationState = calculationState,
        onSizeChange = { inputString ->
            calculationViewModel.onUiEvent(
                calculationEvent = CalculationEvent.SizeChanged(
                    inputValue = inputString
                )
            )

        },
        onFeedRateChange = { inputString ->
            calculationViewModel.onUiEvent(
                calculationEvent = CalculationEvent.FeedRateChanged(
                    inputValue = inputString
                )
            )

        }
    )
}



@Preview(showSystemUi = true)
@Composable
fun PreviewCalculationScreen(){
    GearedgeTheme{
        CalculationScreen()
    }
}