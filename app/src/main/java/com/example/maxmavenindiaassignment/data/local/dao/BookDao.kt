package com.example.maxmavenindiaassignment.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.maxmavenindiaassignment.data.remote.model.Item

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBook(item: Item)

    @Delete
    suspend fun deleteNote(item: Item)

    @Query("SELECT * FROM Item")
    suspend fun showAllBooks(): List<Item>
}