package com.example.topheaderlineretrofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topheaderlineretrofitapi.adapter.TopHeadlineAdapter
import com.example.topheaderlineretrofitapi.api.TopHeadlineApiInterface
import com.example.topheaderlineretrofitapi.model.Article
import com.example.topheaderlineretrofitapi.model.TopHeadline
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getList()
    }

    fun getList() {
        var BASE_URL = "http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var retrofitService = retrofit.create(TopHeadlineApiInterface::class.java)
        var apiCall =retrofitService.getNews("ch","business","abd0cdfe30854b3983f56072d37d2742")
        apiCall.enqueue(object :
            Callback<TopHeadline>{
            override fun onFailure(call: Call<TopHeadline>, t: Throwable) {

            }

            override fun onResponse(call: Call<TopHeadline>, response: Response<TopHeadline>) {
                var list = response.body()?.articles
                Log.d("Article>>>",list.toString())
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = TopHeadlineAdapter(list as ArrayList<Article> )
            }

        })

    }
}
