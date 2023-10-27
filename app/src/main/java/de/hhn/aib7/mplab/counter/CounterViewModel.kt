package de.hhn.aib7.mplab.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val counter: StateFlow<Int> = savedStateHandle.getStateFlow("counter", 0)

    fun increment() {
        savedStateHandle["counter"] = counter.value + 1;
    }

    fun decrement() {
        savedStateHandle["counter"] = counter.value - 1;
    }
}