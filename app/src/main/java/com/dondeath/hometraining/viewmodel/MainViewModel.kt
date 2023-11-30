package com.dondeath.hometraining.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    var text = mutableStateOf("hi there")
        private set

    fun setText(newState: String) {
        text.value = newState
    }
}