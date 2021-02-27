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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyStaticData
@Composable
fun DetailScreen(navController: NavController, puppyId: Int) {
    val puppy = PuppyStaticData.getPuppy(puppyId)
    Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp).fillMaxHeight()) {
        Image(painter = painterResource(id = puppy.resourceImage), contentDescription = puppy.contentDescription)
        Text(
            text = puppy.name,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(puppy.location)
        Text("Breed: ${puppy.breed}")
        Text("Age: ${puppy.age}")
        Button(
            content = { Text("Adopt me!") },
            onClick = {
                // TODO: Adoption screen
            },
            modifier = Modifier.fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 8.dp)
        )
    }
}
