package com.example.kotlinstudyguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudyguide.R
import com.example.kotlinstudyguide.models.AndroidRecyclerData

class AndroidAdapter : RecyclerView.Adapter<RecyclerViewAdapter.AndroidViewHolder>() {

    var androidItems = ArrayList<AndroidRecyclerData>()
    
    fun setUpdatedAndroidData(items : ArrayList<AndroidRecyclerData>) {
        this.androidItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.AndroidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_card_view, parent, false)
        return RecyclerViewAdapter.AndroidViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.AndroidViewHolder, position: Int) {
        holder.androidBind(androidItems.get(position))
    }

    override fun getItemCount(): Int {
        return androidItems.size
    }
}