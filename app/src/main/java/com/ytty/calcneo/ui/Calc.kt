package com.ytty.calcneo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ytty.calcneo.ui.display.Display
import com.ytty.calcneo.ui.keyboard.Keyboard
import com.ytty.calcneo.ui.theme.CalcNeoTheme

@Composable
fun Calc(
    displayText: String,
    modifier: Modifier = Modifier,
    onDigitClick: (digit: Int) -> Unit,
    onCleanClick: () -> Unit,
    onPlusMinusSignClick: () -> Unit,
    onPercentClick: () -> Unit,
    onDivisionClick: () -> Unit,
    onMultiplicationClick: () -> Unit,
    onSubtractionClick: () -> Unit,
    onAdditionClick: () -> Unit,
    onCommaClick: () -> Unit,
    onEqualClick: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Display(
            text = displayText,
            modifier = Modifier
                .width(256.dp)
        )

        Keyboard(
            onDigitClick = onDigitClick,
            onCleanClick = onCleanClick,
            onPlusMinusSignClick = onPlusMinusSignClick,
            onPercentClick = onPercentClick,
            onDivisionClick = onDivisionClick,
            onMultiplicationClick = onMultiplicationClick,
            onSubtractionClick = onSubtractionClick,
            onAdditionClick = onAdditionClick,
            onCommaClick = onCommaClick,
            onEqualClick = onEqualClick
        )
    }

}

@Preview
@Composable
fun CalcPreview() {
    CalcNeoTheme {
        Calc(
            displayText = "555.123",
            onDigitClick = {},
            onCleanClick = {},
            onPlusMinusSignClick = {},
            onPercentClick = {},
            onDivisionClick = {},
            onMultiplicationClick = {},
            onSubtractionClick = {},
            onAdditionClick = {},
            onCommaClick = {},
            onEqualClick = {}
        )
    }
}