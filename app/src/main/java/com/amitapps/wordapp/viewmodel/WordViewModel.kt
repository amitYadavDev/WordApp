package com.amitapps.wordapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amitapps.wordapp.data.model.Word
import com.amitapps.wordapp.repository.WordRepository
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel (private val repository: WordRepository): ViewModel() {
    
    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(word: Word) {
        CoroutineScope(Dispatchers.IO).launch {
                repository.insert(word)
        }
    }
}


//created the ViewModel and implemented a ViewModelProvider.Factory that gets as a parameter
//the dependencies needed to create WordViewModel: the WordRepository.
class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}