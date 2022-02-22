package com.yasintanriverdi.composeintro.samples.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yasintanriverdi.composeintro.model.Person
import com.yasintanriverdi.composeintro.model.personList
import kotlinx.coroutines.launch

@Composable
fun PersonCard(person: Person) {
    Surface(
        elevation = 2.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = person.image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(1.dp, MaterialTheme.colors.onSurface, CircleShape),
                contentDescription = person.name
            )
            Column(Modifier.padding(8.dp)) {
                Text(person.name, color = MaterialTheme.colors.onSurface)
                Text(person.job, color = Color.LightGray)
            }
        }
    }
}

@Composable
fun PersonHeader(character: Char) {
    Text(
        text = character.toString(),
        color = Color.Blue
    )
}


@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    Button(onClick = { onClick() }, modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = android.R.drawable.arrow_up_float),
            modifier = Modifier.size(16.dp),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PeopleListSticky() {
    val grouped = personList.groupBy { it.name[0] }.toSortedMap()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Box {
        LazyColumn(state = listState, contentPadding = PaddingValues(bottom = 80.dp)) {
            grouped.forEach { (initial, peopleForInitial) ->
                stickyHeader {
                    PersonHeader(initial)
                }
                items(peopleForInitial) { person ->
                    PersonCard(person)
                }
            }
        }
        val showButton = listState.firstVisibleItemIndex > 0
        AnimatedVisibility(
            visible = showButton, enter = fadeIn(), exit = fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(index = 0)
                    }
                }
            )
        }
    }
}