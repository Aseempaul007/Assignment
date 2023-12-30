package com.example.maxmavenindiaassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.maxmavenindiaassignment.data.local.dao.BookDao
import com.example.maxmavenindiaassignment.data.local.dao.db.BookDb
import com.example.maxmavenindiaassignment.data.remote.model.BookApiResponse
import com.example.maxmavenindiaassignment.data.remote.model.Item
import com.example.maxmavenindiaassignment.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class BookViewmodel @Inject constructor(
    private val repository: BookRepository,
    private val bookDao: BookDao
): ViewModel() {
    suspend fun getBooks(query: String): Response<BookApiResponse> {
        return repository.getBooks(query)
    }
    suspend fun saveBook(item: Item)  {
        bookDao.addBook(item)
    }
    suspend fun showAllBooks():List<Item>  {
        return repository.showAllBooks()
    }
}