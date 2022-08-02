package com.example.kotlinstudyguide.models

data class KotlinRecyclerList(val kotlin_questions: ArrayList<KotlinRecyclerData>)
data class KotlinRecyclerData(val question : String, val answer : String)

data class AndroidRecyclerList(val android_questions: ArrayList<AndroidRecyclerData>)
data class AndroidRecyclerData(val question: String, val answer: String)

data class ThirdRecyclerList(val third_party_libraries: ArrayList<ThirdRecyclerData>)
data class ThirdRecyclerData(val question: String, val answer: String)