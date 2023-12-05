package com.ytty.calcneo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ytty.calcneo.CalcViewModel
import com.ytty.calcneo.CalcViewModel.Action.AdditionClick
import com.ytty.calcneo.CalcViewModel.Action.CleanClick
import com.ytty.calcneo.CalcViewModel.Action.CommaClick
import com.ytty.calcneo.CalcViewModel.Action.DigitClick
import com.ytty.calcneo.CalcViewModel.Action.DivisionClick
import com.ytty.calcneo.CalcViewModel.Action.EqualClick
import com.ytty.calcneo.CalcViewModel.Action.MultiplicationClick
import com.ytty.calcneo.CalcViewModel.Action.PercentClick
import com.ytty.calcneo.CalcViewModel.Action.PlusMinusSignClick
import com.ytty.calcneo.CalcViewModel.Action.SubtractionClick
import com.ytty.calcneo.ui.display.Display
import com.ytty.calcneo.ui.keyboard.Keyboard
import com.ytty.calcneo.ui.theme.CalcNeoTheme

@Composable
fun Calc(
    state: CalcViewModel.State,
    modifier: Modifier = Modifier,
    onAction: (action: CalcViewModel.Action) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Display(
            text = state.displayText,
            modifier = Modifier
                .width(256.dp)
        )

        Keyboard(
            onDigitClick = { onAction(DigitClick(it)) },
            onCleanClick = { onAction(CleanClick) },
            onPlusMinusSignClick = { onAction(PlusMinusSignClick) },
            onPercentClick = { onAction(PercentClick) },
            onDivisionClick = { onAction(DivisionClick) },
            onMultiplicationClick = { onAction(MultiplicationClick) },
            onSubtractionClick = { onAction(SubtractionClick) },
            onAdditionClick = { onAction(AdditionClick) },
            onCommaClick = { onAction(CommaClick) },
            onEqualClick = { onAction(EqualClick) }
        )
    }

}

@Preview
@Composable
fun CalcPreview() {
    CalcNeoTheme {
        Calc(
            state = CalcViewModel.State.empty(),
            onAction = {}
        )
    }
}