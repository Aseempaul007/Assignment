package com.example.maxmavenindiaassignment.data.remote.model

data class BookApiResponse(
    val items: List<Item>?,
    val kind: String?,
    val totalItems: Int?
)