package com.nifed.gearedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nifed.gearedge.ui.screens.calculation.CalculationScreen
import com.nifed.gearedge.ui.theme.GearedgeGrayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GearedgeGrayTheme{
                Surface {
                    CalculationScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    GearedgeGrayTheme {
        Surface {
            CalculationScreen()
        }
    }
}