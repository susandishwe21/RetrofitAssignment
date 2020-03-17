package com.example.topheaderlineretrofitapi.api

import com.example.topheaderlineretrofitapi.model.Article
import com.example.topheaderlineretrofitapi.model.TopHeadline
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlineApiInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Call<TopHeadline>
}