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
package com.example.androiddevchallenge.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.composable.Error
import com.example.androiddevchallenge.ui.composable.Loading

@Composable
fun DetailScreen(navController: NavController, puppyId: Int, detailViewModel: DetailViewModel = viewModel()) {

    LaunchedEffect(1) { // key1 has the value 1 because potato. If it is a var it will be relaunched when the value changes, since I dont want to relaunch it, it is just 1 forever
        // TODO: Dont like this much, however it doesnt navigate without this since it keeps asking for puppies when rebuilding. Should I move the navController up to the viewmodel?
        // TODO: Peek other puppy apps to see how they handle this
        detailViewModel.launchIntent(DetailIntent.LoadPuppy(puppyId))
    }

    val state: DetailState by detailViewModel.state.observeAsState(DetailState.LoadingPuppy)
    when (state) {
        is DetailState.LoadingPuppy -> Loading()
        is DetailState.ErrorPuppy -> Error(text = "Error loading puppy. This is a 1/10 probability and its forced just to show the error state")
        is DetailState.PuppyObtained -> PuppyDetail((state as DetailState.PuppyObtained).puppy)
    }
}

@Composable
fun PuppyDetail(puppy: Puppy) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Image(painter = painterResource(id = puppy.resourceImage), contentDescription = puppy.contentDescription)
        Card(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            shape = RoundedCornerShape(CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp))
        ) {
            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = puppy.name,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "Location"
                    )
                    Text(puppy.location)
                }
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.cat_footprint),
                        contentDescription = "Breed"
                    )
                    Text(puppy.breed)
                }
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.sand_clock),
                        contentDescription = "Age"
                    )
                    Text(puppy.age)
                }
                Button(
                    content = { Text("Adopt me!") },
                    onClick = {
                        // TODO: Adoption screen
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}
