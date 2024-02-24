package com.nifed.gearedge.ui.screens.calculation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nifed.gearedge.R
import com.nifed.gearedge.ui.common.GearEdgeTextField
import com.nifed.gearedge.ui.screens.calculation.state.CalculationEvent
import com.nifed.gearedge.ui.screens.calculation.state.CalculationState


@Composable
fun CalculationInputs(
    calculationState: CalculationState,
    onSpeedChange: (String) -> Unit,
    onFeedRateChange: (String) -> Unit
){

    val padding = 4.dp

    Column(
        modifier = Modifier
            .fillMaxSize().padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        // TODO Recreate  ///////////////////////////

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            val fontSize = 24.sp

            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)
                .padding(top = 6.dp)) {
                Text(text = "-", fontSize = fontSize)
            }

            GearEdgeTextField(
                modifier = Modifier.weight(4f),
                value = calculationState.speed,
                onValueChange = onSpeedChange,
                label = stringResource(id = R.string.calculation_speed_label),
                imeAction = ImeAction.Next
            )

            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)
            .padding(top = 6.dp)) {
                Text(text = "+", fontSize = fontSize)
            }
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            val fontSize = 24.sp

            OutlinedButton(
                onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)
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
                onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)
                    .padding(top = 6.dp)
            ) {
                Text(text = "+", fontSize = fontSize)
            }
        }

        //////////////////////////////////////////


    }
}

@Preview
@Composable
fun CalculationInputsPreview(){

    CalculationScreen()
}