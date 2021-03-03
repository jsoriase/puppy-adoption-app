package com.example.androiddevchallenge.ui.screens.list

import com.example.androiddevchallenge.base.MviAction
import com.example.androiddevchallenge.base.MviIntent
import com.example.androiddevchallenge.base.MviState
import com.example.androiddevchallenge.model.Puppy

sealed class  ListAction : MviAction {
    object LoadPuppies: ListAction()
    class ShowPuppy(val id: Int): ListAction()
}

sealed class ListState : MviState {
    class PuppyList(val puppies : List<Puppy>) : ListState()
    object LoadingPuppies : ListState()
    object ErrorPuppies : ListState()
    class NavigateToPuppy(val id: Int) : ListState()
}

sealed class ListIntent : MviIntent {
    object LoadPuppies: ListIntent()
    class ShowPuppy(val id: Int): ListIntent()
}