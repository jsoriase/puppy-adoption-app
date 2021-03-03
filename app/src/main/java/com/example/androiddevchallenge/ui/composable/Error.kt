package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.example.androiddevchallenge.R

@Composable
fun Error(text: String) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.error_dog) }
    val animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        LottieAnimation(
            animationSpec,
            modifier = Modifier.size(100.dp),
            animationState
        )
        Text(text = text, modifier = Modifier.padding(horizontal = 16.dp))
    }
}