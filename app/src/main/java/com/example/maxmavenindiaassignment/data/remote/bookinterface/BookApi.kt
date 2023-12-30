package com.example.maxmavenindiaassignment.data.remote.bookinterface

import com.example.maxmavenindiaassignment.data.remote.model.BookApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String
    ): Response<BookApiResponse>




}