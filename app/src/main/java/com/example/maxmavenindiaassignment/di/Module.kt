package com.example.maxmavenindiaassignment.di

import android.content.Context
import androidx.room.Room
import com.example.maxmavenindiaassignment.data.local.dao.BookDao
import com.example.maxmavenindiaassignment.data.local.dao.db.BookDb
import com.example.maxmavenindiaassignment.data.remote.bookinterface.BookApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getBookApi(retrofit: Retrofit): BookApi{
        return retrofit.create(BookApi::class.java)
    }

    @Singleton
    @Provides
    fun getRoomDbIns(@ApplicationContext context: Context): BookDb{
        synchronized(this){
            return Room.databaseBuilder(
                context,
                BookDb::class.java,
                "notes_db"
            ).build()
        }
    }

    @Provides
    @Singleton
    fun getBookDao(bookDb: BookDb): BookDao{
        return bookDb.bookDao()
    }
}