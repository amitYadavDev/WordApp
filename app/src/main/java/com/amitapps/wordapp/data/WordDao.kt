package com.amitapps.wordapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amitapps.wordapp.data.model.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    //Getting all words ordered alphabetically
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    //Inserting a word
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    //Deleting all words
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}