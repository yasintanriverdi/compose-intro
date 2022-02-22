package com.yasintanriverdi.composeintro.samples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SimpleText(message: String = "Hello") {
    Text(
        text = message,
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .border(BorderStroke(width = 2.dp, Color.Green))
            .background(Color.DarkGray)
            .padding(16.dp)
            .clickable {
                println("$message clicked")
            },
        color = Color.Cyan
    )
}