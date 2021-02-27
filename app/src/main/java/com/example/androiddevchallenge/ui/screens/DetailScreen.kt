package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyStaticData
@Composable
fun DetailScreen(navController: NavController, puppyId: Int) {
    val puppy = PuppyStaticData.getPuppy(puppyId)
    Image(painter = painterResource(id = puppy.resourceImage), contentDescription = puppy.contentDescription)
}
