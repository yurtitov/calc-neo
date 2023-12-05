package com.ytty.calcneo.ui.keyboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ytty.calcneo.R
import com.ytty.calcneo.ui.theme.CalcNeoTheme

@Composable
fun CalcButton(
    text: String,
    containerColor: Color = colorResource(id = R.color.gray_500),
    contentColor: Color = colorResource(id = R.color.white),
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minHeight = 56.dp, minWidth = 56.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor)
    ) {
        Box(
            modifier = Modifier
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleLarge,
                color = contentColor,
                maxLines = 1,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    CalcNeoTheme {
        CalcButton(text = "8") {}
    }
}