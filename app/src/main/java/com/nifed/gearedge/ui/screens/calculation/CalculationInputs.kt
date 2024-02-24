package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.nifed.gearedge.R
import com.nifed.gearedge.ui.common.GearEdgeTextField
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState


@Composable
fun CalculationInputs(
    calculationState: CalculationState,
    onSpeedChange: (String) -> Unit,
    onFeedRateChange: (String) -> Unit
){
    Column(modifier = Modifier.fillMaxWidth()){

        GearEdgeTextField(
            value = calculationState.speed,
            onValueChange = onSpeedChange,
            label = stringResource(id = R.string.calculation_speed_label),
            imeAction = ImeAction.Next
        )

        GearEdgeTextField(
            value = calculationState.feedRate,
            onValueChange = onFeedRateChange,
            label = stringResource(id = R.string.calculation_feed_rate_label),
            imeAction = ImeAction.Done
        )



    }
}