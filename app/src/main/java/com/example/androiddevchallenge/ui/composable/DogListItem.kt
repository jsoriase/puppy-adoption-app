package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DogListItem(puppy: Puppy, onClick: () -> Unit) {

    val image = painterResource(id = puppy.resourceImage)
    Row(verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth().clickable(onClick = onClick)) {
        Image(painter = image,
            contentDescription = puppy.contentDescription,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillHeight
        )
        Column {
            Text(puppy.name)
            Text(puppy.subtitle)
        }
    }
}

@Preview("Light Theme")
@Composable
fun DogListItemLight() {
    MyTheme {
        DogListItem(Puppy(1, "Doggo", "White", R.drawable.chihuahua1, "White Chihuahua dog")) {}
    }
}

@Preview("Dark Theme")
@Composable
fun DogListItemDark() {
    MyTheme(darkTheme = true) {
        DogListItem(Puppy(2, "Doggo", "White", R.drawable.chihuahua2, "White Chihuahua dog")) {}
    }
}