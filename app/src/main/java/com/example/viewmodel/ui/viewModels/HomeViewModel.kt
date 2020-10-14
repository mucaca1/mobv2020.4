package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val word: MutableLiveData<String> = MutableLiveData()

    //TODO: 6b.urobit transformaciu slova aby sa zobrazoval text "Slovo je: "
}
