package com.yasintanriverdi.composeintro.samples

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedBoxVisibility() {
    var visible by remember {
        mutableStateOf(true)
    }
    Column {
        Button(
            onClick = { visible = !visible }
        ) {
            Text(text = if (visible) "HIDE" else "SHOW")
        }
        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible) {
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(Color.Blue)
            )
        }
    }
}


enum class BoxState {
    Small,
    Large
}

@Composable
fun AnimatedBoxSize() {
    var boxState by remember {
        mutableStateOf(BoxState.Small)
    }
    val size by animateDpAsState(
        targetValue = if (boxState == BoxState.Small) 64.dp else 128.dp,
        animationSpec = tween(2000)
    )
    Column {
        Button(
            onClick = {
                boxState = when (boxState) {
                    BoxState.Small -> BoxState.Large
                    BoxState.Large -> BoxState.Small
                }
            }
        ) { Text(text = "Change size") }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(size)
                .background(Color.Blue)
        )
    }
}

@Composable
fun AnimateBoxColorAndSize() {
    var boxState by remember { mutableStateOf(BoxState.Small) }
    val transition = updateTransition(targetState = boxState, label = "")
    val color by transition.animateColor(label = "") { state ->
        when (state) {
            BoxState.Small -> Color.Blue
            BoxState.Large -> Color.Yellow
        }
    }
    val size by transition.animateDp(label = "") { state ->
        when (state) {
            BoxState.Small -> 64.dp
            BoxState.Large -> 128.dp
        }
    }
    Column {
        Button(onClick = {
            boxState = when (boxState) {
                BoxState.Small -> BoxState.Large
                BoxState.Large -> BoxState.Small
            }
        }
        ) { Text(text = "Change size and color") }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .size(size)
            .background(color))
    }
}

@Composable
fun AnimateFaq(
    question: String = "How many points will I get?",
    answer: String = "lorem ipsum dolor sit amet consectetur adipiscing elit"
) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = question, color = Color.Black)
            Spacer(modifier = Modifier.weight(1.0f))
            Image(
                painter = painterResource(id = if (expanded) android.R.drawable.arrow_up_float else android.R.drawable.arrow_down_float),
                contentDescription = "",
                Modifier
                    .size(16.dp)
                    .clickable {
                        expanded = !expanded
                    }
            )
        }
        AnimatedVisibility(expanded) {
            Text(text = answer, color = Color.Gray)
        }
    }
}