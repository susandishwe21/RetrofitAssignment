package com.example.topheaderlineretrofitapi.model

data class TopHeadline(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)