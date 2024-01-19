package com.example.khabarapplication.Models

data class NewsResponse1(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)