package com.example.kotlinstudyguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudyguide.R
import com.example.kotlinstudyguide.models.AndroidRecyclerData
import com.example.kotlinstudyguide.models.KotlinRecyclerData

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.KotlinViewHolder>() {

    var kotlinItems = ArrayList<KotlinRecyclerData>() /** For Kotlin */

    /**
     * set Kotlin Data
     */
    fun setUpdatedKotlinData(items : ArrayList<KotlinRecyclerData>) {
        this.kotlinItems = items
        notifyDataSetChanged()
    }

    /**
     * Had to put this view holder in here for some reason
     * This is the Android Questions View Holder that is used in the Android Adapter
     */
    class AndroidViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvQuestion = view.findViewById<TextView>(R.id.tvQuestion)
        val tvAnswer = view.findViewById<TextView>(R.id.tvAnswer)

        fun androidBind(dataAndroid : AndroidRecyclerData) {
            tvQuestion.text = dataAndroid.question
            tvAnswer.text = dataAndroid.answer
        }
    }

    /**
     * Kotlin View Holder
     */
    class KotlinViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvQuestion = view.findViewById<TextView>(R.id.tvQuestion)
        val tvAnswer = view.findViewById<TextView>(R.id.tvAnswer)

        fun kotlinBind(dataKotlin : KotlinRecyclerData) {
            tvQuestion.text = dataKotlin.question
            tvAnswer.text = dataKotlin.answer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KotlinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kotlin_card_view, parent, false)

        return KotlinViewHolder(view)
    }

    override fun onBindViewHolder(holder: KotlinViewHolder, position: Int) {
        holder.kotlinBind(kotlinItems.get(position))
    }

    override fun getItemCount(): Int {
        return kotlinItems.size
    }
}