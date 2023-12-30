package com.example.maxmavenindiaassignment.data.local.dao.converter

import androidx.room.TypeConverter
import com.example.maxmavenindiaassignment.data.remote.model.AccessInfo
import com.google.gson.Gson

class AccessInfoTypeconveretr {

    @TypeConverter
    fun fromAccessInfo(accessInfo: AccessInfo?): String? {
        return Gson().toJson(accessInfo)
    }

    @TypeConverter
    fun toAccessInfo(json: String?): AccessInfo? {
        return if (json.isNullOrEmpty()) null else Gson().fromJson(json, AccessInfo::class.java)
    }
}