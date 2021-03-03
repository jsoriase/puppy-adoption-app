/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.composable.DogListItem
import com.example.androiddevchallenge.ui.composable.Loading

@Composable
fun ListScreen(navController: NavController, listViewModel: ListViewModel = viewModel()) {

    LaunchedEffect(1) { //key1 has the value 1 because potato. If it is a var it will be relaunched when the value changes, since I dont want to relaunch it, it is just 1 forever
        //TODO: Dont like this much, however it doesnt navigate without this since it keeps asking for puppies when rebuilding. Should I move the navController up to the viewmodel?
        //TODO: Peek other puppy apps to see how they handle this
        listViewModel.launchIntent(ListIntent.LoadPuppies)
    }

    val state: ListState by listViewModel.state.observeAsState(ListState.LoadingPuppies)
    when(state){
        is ListState.LoadingPuppies -> Loading()
        is ListState.PuppyList -> PuppyList(puppies = (state as ListState.PuppyList).puppies)
        is ListState.ErrorPuppies -> Error("An error happened when loading the puppies")
        is ListState.NavigateToPuppy -> navController.navigate("puppy/${(state as ListState.NavigateToPuppy).id}")
    }
}

@Composable
fun PuppyList(puppies: List<Puppy>) {

    val listViewModel: ListViewModel = viewModel()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        items(puppies) { puppy ->
            DogListItem(puppy = puppy) {
                listViewModel.launchIntent(ListIntent.ShowPuppy(puppy.id))
            }
        }
    }
}


