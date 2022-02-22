package com.yasintanriverdi.composeintro.samples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextWithCounter() {
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You clicked $counter times")
        Button(onClick = { counter++ }) {
            Text("Update counter")
        }
    }
}

@Composable
fun CongratsMessageCounter() {
    var counter by rememberSaveable { mutableStateOf(0) }
    if (counter < 5) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "You clicked $counter times")
            Button(onClick = { counter++ }) {
                Text("Update counter")
            }
        }
    } else {
        Text(
            text = "Congrats",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TadaImageCounter() {
    var counter by rememberSaveable { mutableStateOf(0) }
    if (counter < 7) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "You clicked $counter times")
            Button(onClick = { counter++ }) {
                Text("Update counter")
            }
        }
    } else {
        Image(
            painter = painterResource(id = com.yasintanriverdi.composeintro.R.drawable.tada),
            modifier = Modifier
                .fillMaxWidth()
                .size(120.dp)
                .padding(16.dp),
            contentDescription = "tada",
        )
    }
}