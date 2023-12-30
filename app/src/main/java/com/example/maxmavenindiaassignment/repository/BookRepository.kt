package com.example.maxmavenindiaassignment.repository

import com.example.maxmavenindiaassignment.data.local.dao.BookDao
import com.example.maxmavenindiaassignment.data.remote.bookinterface.BookApi
import com.example.maxmavenindiaassignment.data.remote.model.BookApiResponse
import com.example.maxmavenindiaassignment.data.remote.model.Item
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class BookRepository @Inject constructor(
    private val bookApi: BookApi,
    private val bookDao: BookDao
) {
    suspend fun getBooks(query: String): Response<BookApiResponse> {
         return bookApi.getBooks(query)
     }

    suspend fun saveBook(item: Item)  {
        bookDao.addBook(item)
    }

    suspend fun showAllBooks(): List<Item> {
        return bookDao.showAllBooks()
    }
}