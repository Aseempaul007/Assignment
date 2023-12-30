package com.example.maxmavenindiaassignment.data.local.dao.converter

import androidx.room.TypeConverter
import com.example.maxmavenindiaassignment.data.remote.model.AccessInfo
import com.example.maxmavenindiaassignment.data.remote.model.SaleInfo
import com.example.maxmavenindiaassignment.data.remote.model.SearchInfo
import com.google.gson.Gson

class SearchInfoTypeconveretr {

    @TypeConverter
    fun fromSearchInfo(searchInfo: SearchInfo?): String? {
        return Gson().toJson(searchInfo)
    }

    @TypeConverter
    fun toSearchInfo(json: String?): SearchInfo? {
        return if (json.isNullOrEmpty()) null else Gson().fromJson(json, SearchInfo::class.java)
    }
}