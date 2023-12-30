package com.example.maxmavenindiaassignment.data.local.dao.converter

import androidx.room.TypeConverter
import com.example.maxmavenindiaassignment.data.remote.model.AccessInfo
import com.example.maxmavenindiaassignment.data.remote.model.SaleInfo
import com.example.maxmavenindiaassignment.data.remote.model.SearchInfo
import com.example.maxmavenindiaassignment.data.remote.model.VolumeInfo
import com.google.gson.Gson

class VolumeInfoTypeconverter {

    @TypeConverter
    fun fromVolumeInfo(volumeInfo: VolumeInfo?): String? {
        return Gson().toJson(volumeInfo)
    }

    @TypeConverter
    fun toVolumeInfo(json: String?): VolumeInfo? {
        return if (json.isNullOrEmpty()) null else Gson().fromJson(json, VolumeInfo::class.java)
    }
}