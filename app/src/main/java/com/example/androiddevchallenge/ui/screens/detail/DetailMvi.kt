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

import com.example.androiddevchallenge.base.MviAction
import com.example.androiddevchallenge.base.MviIntent
import com.example.androiddevchallenge.base.MviState
import com.example.androiddevchallenge.model.Puppy

sealed class DetailAction : MviAction {
    class LoadPuppy(val id: Int) : DetailAction()
    object AdoptPuppy : DetailAction()
}

sealed class DetailState : MviState {
    class PuppyObtained(val puppy: Puppy) : DetailState()
    object LoadingPuppy : DetailState()
    object ErrorPuppy : DetailState()
}

sealed class DetailIntent : MviIntent {
    class LoadPuppy(val id: Int) : DetailIntent()
    object AdoptPuppy : DetailIntent()
}
