package com.example.maxmavenindiaassignment.data.local.dao.converter

import androidx.room.TypeConverter
import com.example.maxmavenindiaassignment.data.remote.model.AccessInfo
import com.example.maxmavenindiaassignment.data.remote.model.SaleInfo
import com.google.gson.Gson

class SalesInfoTypeconveretr {

    @TypeConverter
    fun fromSalesInfo(saleInfo: SaleInfo?): String? {
        return Gson().toJson(saleInfo)
    }

    @TypeConverter
    fun toSalesInfo(json: String?): SaleInfo? {
        return if (json.isNullOrEmpty()) null else Gson().fromJson(json, SaleInfo::class.java)
    }
}