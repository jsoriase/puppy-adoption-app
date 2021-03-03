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
package com.example.androiddevchallenge.ui.screens.list

import com.example.androiddevchallenge.base.MviAction
import com.example.androiddevchallenge.base.MviIntent
import com.example.androiddevchallenge.base.MviState
import com.example.androiddevchallenge.model.Puppy

sealed class ListAction : MviAction {
    object LoadPuppies : ListAction()
    class ShowPuppy(val id: Int) : ListAction()
}

sealed class ListState : MviState {
    class PuppyList(val puppies: List<Puppy>) : ListState()
    object LoadingPuppies : ListState()
    object ErrorPuppies : ListState()
    class NavigateToPuppy(val id: Int) : ListState()
}

sealed class ListIntent : MviIntent {
    object LoadPuppies : ListIntent()
    class ShowPuppy(val id: Int) : ListIntent()
}
