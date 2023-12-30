package com.example.maxmavenindiaassignment.data.local.dao.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.maxmavenindiaassignment.data.local.dao.BookDao
import com.example.maxmavenindiaassignment.data.local.dao.converter.AccessInfoTypeconveretr
import com.example.maxmavenindiaassignment.data.local.dao.converter.SalesInfoTypeconveretr
import com.example.maxmavenindiaassignment.data.local.dao.converter.SearchInfoTypeconveretr
import com.example.maxmavenindiaassignment.data.local.dao.converter.VolumeInfoTypeconverter
import com.example.maxmavenindiaassignment.data.remote.model.Item

@Database(
    entities = [Item::class],
    version = 1
)
@TypeConverters(
    AccessInfoTypeconveretr::class,
    SalesInfoTypeconveretr::class,
    SearchInfoTypeconveretr::class,
    VolumeInfoTypeconverter::class
)
abstract class BookDb: RoomDatabase() {
    abstract fun bookDao(): BookDao
}