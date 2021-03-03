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
package com.example.androiddevchallenge.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<I : MviIntent, A : MviAction, S : MviState> : ViewModel() {

    // This is the state the composable will observe
    protected val _state = MutableLiveData<S>()
    val state: LiveData<S> = _state

    // This function recieves andintent, converts it to action and handles it
    fun launchIntent(intent: I) {
        handleAction(intentToAction(intent))
    }

    // This abstract function will convert the intents to actions
    // Seems that a lot of times intents will be equivalent to actions,
    // But there could be different intents leading to the same action
    // Or intents that depending on the state would lead to different actions
    protected abstract fun intentToAction(intent: I): A

    // Once the action is obtained according to the intent and the internal state,
    // We need to handle it, call wherever we need and convert the results to states
    // via _state.postValue(STATE)
    protected abstract fun handleAction(action: A)
}
