package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.*
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DataRepository) : ViewModel() {

    var liveText: MutableLiveData<String> = MutableLiveData()

    var text: LiveData<String> = Transformations.map(repository.getWords()) { it.toString() }

    fun insertWord() {
        liveText.value?.let {
            viewModelScope.launch {
                repository.insertWord(WordItem(it))
                liveText.postValue("")
            }
        }
    }

    fun deleteWord() {
        liveText.value?.let {
            viewModelScope.launch {
                repository.deleteWord(WordItem(it))
                liveText.postValue("")
            }
        }
    }

    fun deleteSubWord() {
        liveText.value?.let {
            viewModelScope.launch {
                repository.deleteSubWord(WordItem(it))
                liveText.postValue("")
            }
        }
    }
}
