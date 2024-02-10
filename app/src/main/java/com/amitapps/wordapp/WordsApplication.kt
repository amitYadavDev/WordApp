package com.amitapps.wordapp

import android.app.Application
import com.amitapps.wordapp.data.WordRoomDatabase
import com.amitapps.wordapp.repository.WordRepository

class WordsApplication : Application() {
    val database by lazy { WordRoomDatabase.getInstance(this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}