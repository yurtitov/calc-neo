package com.ytty.calcneo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ytty.calcneo.ui.Calc
import com.ytty.calcneo.ui.theme.CalcNeoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcNeoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calc(
                        displayText = "123",
                        onDigitClick = {},
                        onCleanClick = {},
                        onPlusMinusSignClick = {},
                        onPercentClick = {},
                        onDivisionClick = {},
                        onMultiplicationClick = {},
                        onSubtractionClick = {},
                        onAdditionClick = {},
                        onCommaClick = {},
                        onEqualClick = {})
                }
            }
        }
    }
}