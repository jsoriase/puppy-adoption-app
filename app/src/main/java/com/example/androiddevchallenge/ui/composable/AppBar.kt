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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.PuppyTheme

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: @Composable RowScope.() -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = modifier,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
            actions = actions,
            title = { Row { title() } },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.dog_jump),
                    contentDescription = "app bar icon",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        )
        Divider()
    }
}

@Preview
@Composable
fun AppBarPreview() {
    PuppyTheme {
        AppBar(title = { Text("Preview!") })
    }
}

@Preview
@Composable
fun AppBarPreviewDark() {
    PuppyTheme(darkTheme = true) {
        AppBar(title = { Text("Preview!") })
    }
}
