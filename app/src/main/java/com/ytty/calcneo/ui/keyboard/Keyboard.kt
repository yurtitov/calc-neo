package com.ytty.calcneo.ui.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ytty.calcneo.R
import com.ytty.calcneo.ui.theme.CalcNeoTheme

@Composable
fun Keyboard(
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row {
            CalcButton(
                text = "C",
                containerColor = colorResource(id = R.color.gray),
                contentColor = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(4.dp)
            ) { onCleanClick() }

            CalcButton(
                text = "+/-",
                containerColor = colorResource(id = R.color.gray),
                contentColor = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(4.dp)
            ) { onPlusMinusSignClick() }

            CalcButton(
                text = "%",
                containerColor = colorResource(id = R.color.gray),
                contentColor = colorResource(id = R.color.black),
                modifier = Modifier
                    .padding(4.dp)
            ) { onPercentClick() }

            CalcButton(
                text = "/",
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
            ) { onDivisionClick() }
        }
        
        Row {
            CalcButton(
                text = "7",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(7) }

            CalcButton(
                text = "8",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(8) }

            CalcButton(
                text = "9",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(9) }

            CalcButton(
                text = "X",
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
            ) { onMultiplicationClick() }
        }

        Row {
            CalcButton(
                text = "4",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(4) }

            CalcButton(
                text = "5",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(5) }

            CalcButton(
                text = "6",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(6) }

            CalcButton(
                text = "-",
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
            ) { onSubtractionClick() }
        }

        Row {
            CalcButton(
                text = "1",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(1) }

            CalcButton(
                text = "2",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(2) }

            CalcButton(
                text = "3",
                modifier = Modifier
                    .padding(4.dp)
            ) { onDigitClick(3) }

            CalcButton(
                text = "+",
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
            ) { onAdditionClick() }
        }

        Row {
            CalcButton(
                text = "0",
                modifier = Modifier
                    .width(130.dp)
                    .padding(4.dp)
            ) { onDigitClick(0) }

            CalcButton(
                text = ",",
                modifier = Modifier
                    .padding(4.dp)
            ) { onCommaClick() }

            CalcButton(
                text = "=",
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .padding(4.dp)
            ) { onEqualClick() }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    CalcNeoTheme {
        Keyboard(
            onDigitClick = {},
            onCleanClick = {},
            onPlusMinusSignClick = {},
            onPercentClick = {},
            onMultiplicationClick = {},
            onDivisionClick = {},
            onSubtractionClick = {},
            onAdditionClick = {},
            onCommaClick = {},
            onEqualClick = {},
        )
    }
}