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
package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.PuppyStaticData
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.PuppyTheme

@Composable
fun DogListItem(puppy: Puppy, onClick: () -> Unit) {

    Card(
        shape = RoundedCornerShape(CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)
        ) {
            Image(
                painter = painterResource(id = puppy.resourceImage),
                contentDescription = puppy.contentDescription,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp), CornerSize(16.dp))),
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = puppy.name,
                    color = MaterialTheme.colors.primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = puppy.breed,
                    fontSize = 14.sp
                )
                Text(
                    text = puppy.location,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview("Light Theme")
@Composable
fun DogListItemLight() {
    PuppyTheme {
        val puppy = PuppyStaticData.getPuppy(1)
        DogListItem(puppy) {}
    }
}

@Preview("Dark Theme")
@Composable
fun DogListItemDark() {
    PuppyTheme(darkTheme = true) {
        val puppy = PuppyStaticData.getPuppy(1)
        DogListItem(puppy) {}
    }
}
