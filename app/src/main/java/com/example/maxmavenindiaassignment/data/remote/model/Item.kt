package com.example.maxmavenindiaassignment.data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Item(
    val accessInfo: AccessInfo?,
    val etag: String?,
    @PrimaryKey(autoGenerate = true)
    val my_id: Int?,
    val id: String?,
    val kind: String?,
    val saleInfo: SaleInfo?,
    val searchInfo: SearchInfo?,
    val selfLink: String?,
    val volumeInfo: VolumeInfo?
): Serializable