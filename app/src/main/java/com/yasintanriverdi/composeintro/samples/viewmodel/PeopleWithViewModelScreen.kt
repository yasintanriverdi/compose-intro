package com.yasintanriverdi.composeintro.samples.viewmodel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.*
import com.yasintanriverdi.composeintro.samples.list.PersonCard
import com.yasintanriverdi.composeintro.samples.list.PersonHeader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PeopleListViaViewModel(viewModel: PeopleViewModel = viewModel()) {
    val peopleMap = viewModel.uiState.collectAsState()

    Box {
        LazyColumn {
            peopleMap.value.forEach { (initial, peopleForInitial) ->
                stickyHeader {
                    PersonHeader(initial)
                }

                items(peopleForInitial) { person ->
                    PersonCard(person)
                }
            }
        }
    }
}
