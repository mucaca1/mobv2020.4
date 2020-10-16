package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val input: MutableLiveData<String> = MutableLiveData()
    private val _word: MutableLiveData<String> = MutableLiveData()

    val word: LiveData<String>
        get() {
            return this._word
        }

    fun changeWord() {
        input.value?.apply {
            if (this.isNotEmpty()) {
                _word.value = this
            }
        }
    }

    //TODO: 6b.urobit transformaciu slova aby sa zobrazoval text "Slovo je: "
}
