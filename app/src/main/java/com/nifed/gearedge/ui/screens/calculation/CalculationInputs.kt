package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nifed.gearedge.R
import com.nifed.gearedge.ui.common.GearEdgeTextField
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState


@Composable
fun CalculationInputs(
    calculationState: CalculationState,
    onSizeChange: (String) -> Unit,
    onFeedRateChange: (String) -> Unit,

    onIncreaseSize: () -> Unit,
    onDecreaseSize: () -> Unit,
    onIncreaseFeedRate: () -> Unit,
    onDecreaseFeedRate: () -> Unit
){

    val padding = 4.dp
    val fontSize = 24.sp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        // TODO Recreate  ///////////////////////////

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {


            OutlinedButton(onClick =onDecreaseSize, modifier = Modifier
                .weight(1f)
                .padding(top = 6.dp)) {
                Text(text = "-", fontSize = fontSize)
            }

            GearEdgeTextField(
                modifier = Modifier.weight(4f),
                value = calculationState.size,
                onValueChange = onSizeChange,
                label = stringResource(id = R.string.calculation_size_label),
                imeAction = ImeAction.Next
            )

            OutlinedButton(onClick = onIncreaseSize, modifier = Modifier
                .weight(1f)
                .padding(top = 6.dp)) {
                Text(text = "+", fontSize = fontSize)
            }
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {


            OutlinedButton(
                onClick = onDecreaseFeedRate, modifier = Modifier
                    .weight(1f)
                    .padding(top = 6.dp)
            ) {
                Text(text = "-", fontSize = fontSize)
            }

            GearEdgeTextField(
                modifier = Modifier.weight(4f),
                value = calculationState.feedRate,
                onValueChange = onFeedRateChange,
                label = stringResource(id = R.string.calculation_feed_rate_label),
                imeAction = ImeAction.Done
            )

            OutlinedButton(
                onClick = onIncreaseFeedRate, modifier = Modifier
                    .weight(1f)
                    .padding(top = 6.dp)
            ) {
                Text(text = "+", fontSize = fontSize)
            }
        }

        //////////////////////////////////////////



        Text(text = calculationState.time, fontSize = fontSize)

    }
}



@Preview
@Composable
fun CalculationInputsPreview(){

    CalculationScreen()
}