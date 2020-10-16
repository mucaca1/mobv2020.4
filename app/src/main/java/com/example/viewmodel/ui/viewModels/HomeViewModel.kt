package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val input: MutableLiveData<String> = MutableLiveData()
    val transformText = Transformations.map(input) { w -> "Transformovane slovo je : $w" }
    private val _word: MutableLiveData<String> = MutableLiveData()

    val word: LiveData<String>
        get() {
            return this._word
        }

    fun changeWord() {
        input.value?.apply {
            if (this.isNotEmpty()) {
                _word.value = "Slovo je: " + this
            }
        }
    }
}
