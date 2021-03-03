package com.example.androiddevchallenge.ui.screens.detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.base.BaseViewModel
import com.example.androiddevchallenge.data.PuppyStaticData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

class DetailViewModel : BaseViewModel<DetailIntent, DetailAction, DetailState>() {

    override fun intentToAction(intent: DetailIntent): DetailAction {
        return when(intent) {
            is DetailIntent.LoadPuppy -> DetailAction.LoadPuppy(intent.id)
            is DetailIntent.AdoptPuppy -> DetailAction.AdoptPuppy
        }
    }

    override fun handleAction(action: DetailAction) {

        when(action) {
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
                //TODO: Adopt it!
            }
        }

    }


}