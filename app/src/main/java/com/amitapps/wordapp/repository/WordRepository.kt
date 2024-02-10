package com.amitapps.wordapp.repository

import com.amitapps.wordapp.data.WordDao
import com.amitapps.wordapp.data.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()
}