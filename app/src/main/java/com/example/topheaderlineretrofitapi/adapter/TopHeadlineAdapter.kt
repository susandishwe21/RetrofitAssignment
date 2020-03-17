package com.example.topheaderlineretrofitapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topheaderlineretrofitapi.R
import com.example.topheaderlineretrofitapi.model.Article
import com.example.topheaderlineretrofitapi.model.TopHeadline
import kotlinx.android.synthetic.main.item_list.view.*

class TopHeadlineAdapter(var topList :ArrayList<Article> ) :
    RecyclerView.Adapter<TopHeadlineAdapter.TopHeadlineViewHolder>() {
    inner class TopHeadlineViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(itemList : Article){
            itemView.txtTitle.text = itemList.title
            itemView.txtContent.text = itemList.content
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlineViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return TopHeadlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topList.size
    }

    override fun onBindViewHolder(holder: TopHeadlineViewHolder, position: Int) {
        holder.bind(topList[position])
    }
}