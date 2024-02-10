package com.amitapps.wordapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amitapps.wordapp.data.model.Word
import com.amitapps.wordapp.utils.Constants

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        fun getInstance(context: Context): WordRoomDatabase {
            return Room.databaseBuilder(context, WordRoomDatabase::class.java, Constants.databaseName).build()
        }
    }
}