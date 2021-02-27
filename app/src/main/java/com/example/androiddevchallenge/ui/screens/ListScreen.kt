package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.PuppyStaticData
import com.example.androiddevchallenge.ui.composable.DogListItem

@Composable
fun ListScreen(navController: NavController) {

    val puppies = PuppyStaticData.puppies

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(puppies) { puppy ->
            DogListItem(puppy = puppy) {
                val puppyId = puppy.id
                navController.navigate("puppy/$puppyId")}
        }
    }
}
