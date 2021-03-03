package com.example.androiddevchallenge.ui.screens.list

import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.base.BaseViewModel
import com.example.androiddevchallenge.data.PuppyStaticData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : BaseViewModel<ListIntent, ListAction, ListState>() {

    override fun intentToAction(intent: ListIntent): ListAction {
        //In this case intents are equivalent to action, but i.e there could be a "reset results" and the initial state, which would be 2 intents with the same action
        return when(intent) {
            is ListIntent.LoadPuppies -> ListAction.LoadPuppies
            is ListIntent.ShowPuppy -> ListAction.ShowPuppy(intent.id)
        }
    }

    override fun handleAction(action: ListAction) {
        when(action) {
            is ListAction.LoadPuppies -> {
                viewModelScope.launch(Dispatchers.IO) {
                    //In typical MVI here the action results should be reduced, since we should obtain a result which could be success, loading or error.
                    //We're setting loading by default so this isnt needed right now, but could be in case of refresh.
                    //Results should be yielded instead of being synchronous, so an interactor should yield loading and then error or success.
                    _state.postValue(ListState.LoadingPuppies)
                    Thread.sleep(500)
                    _state.postValue(ListState.PuppyList(PuppyStaticData.puppies))
                }
            }
            is ListAction.ShowPuppy -> {
                _state.value = ListState.NavigateToPuppy(action.id) //TODO: Should I navigate from here instead of from the view?
            }
        }
    }

}

