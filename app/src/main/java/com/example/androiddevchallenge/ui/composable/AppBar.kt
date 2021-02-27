package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: @Composable RowScope.() -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = modifier,
            elevation = 0.dp,
            contentColor = MaterialTheme.colors.onSurface,
            actions = actions,
            title = { Row { title() } },
            navigationIcon = {
                Icon(painter = painterResource(id = R.drawable.dog_jump),
                    contentDescription = "app bar icon")
            }
        )
        Divider()
    }
}

@Preview
@Composable
fun CntAppBarPreview() {
    MyTheme() {
        AppBar(title = { Text("Preview!") })
    }
}

@Preview
@Composable
fun CntAppBarPreviewDark() {
    MyTheme(darkTheme = true) {
        AppBar(title = { Text("Preview!") })
    }
}