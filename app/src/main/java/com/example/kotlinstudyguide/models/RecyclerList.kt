package com.example.kotlinstudyguide.models

//data class RecyclerList(val kotlin_questions: ArrayList<RecyclerData>)
//data class RecyclerData(val question : String, val answer : String)

data class RecyclerList(val items: ArrayList<RecyclerData>)
data class RecyclerData(val name: String, val description: String)