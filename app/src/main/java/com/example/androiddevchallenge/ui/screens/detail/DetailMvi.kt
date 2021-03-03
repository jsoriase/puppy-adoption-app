package com.example.androiddevchallenge.ui.screens.detail

import com.example.androiddevchallenge.base.MviAction
import com.example.androiddevchallenge.base.MviIntent
import com.example.androiddevchallenge.base.MviState
import com.example.androiddevchallenge.model.Puppy

sealed class  DetailAction : MviAction {
    class LoadPuppy(val id: Int): DetailAction()
    object AdoptPuppy: DetailAction()
}

sealed class DetailState : MviState {
    class PuppyObtained(val puppy: Puppy) : DetailState()
    object LoadingPuppy : DetailState()
    object ErrorPuppy : DetailState()
}

sealed class DetailIntent : MviIntent {
    class LoadPuppy(val id: Int): DetailIntent()
    object AdoptPuppy: DetailIntent()
}