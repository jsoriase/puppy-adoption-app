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

import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.base.BaseViewModel
import com.example.androiddevchallenge.data.PuppyStaticData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class DetailViewModel : BaseViewModel<DetailIntent, DetailAction, DetailState>() {

    override fun intentToAction(intent: DetailIntent): DetailAction {
        return when (intent) {
            is DetailIntent.LoadPuppy -> DetailAction.LoadPuppy(intent.id)
            is DetailIntent.AdoptPuppy -> DetailAction.AdoptPuppy
        }
    }

    override fun handleAction(action: DetailAction) {

        when (action) {
            is DetailAction.LoadPuppy -> {
                viewModelScope.launch(Dispatchers.IO) {
                    Thread.sleep(200)
                    val puppy = PuppyStaticData.getPuppy(action.id)

                    val random = Random.nextInt(0, 10)
                    if (random == 9) {
                        _state.postValue(DetailState.ErrorPuppy)
                    } else {
                        _state.postValue(DetailState.PuppyObtained(puppy))
                    }
                }
            }
            is DetailAction.AdoptPuppy -> {
                // TODO: Adopt it!
            }
        }
    }
}
