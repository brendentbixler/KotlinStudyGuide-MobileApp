package com.example.kotlinstudyguide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudyguide.R
import com.example.kotlinstudyguide.models.ThirdRecyclerData

class ThirdAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ThirdViewHolder>() {

    var thirdItems = ArrayList<ThirdRecyclerData>()

    fun setUpdatedThirdData(items : ArrayList<ThirdRecyclerData>) {
        this.thirdItems = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ThirdViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_card_view, parent, false)
        return RecyclerViewAdapter.ThirdViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ThirdViewHolder, position: Int) {
        holder.thirdBind(thirdItems.get(position))
    }

    override fun getItemCount(): Int {
        return thirdItems.size
    }

}