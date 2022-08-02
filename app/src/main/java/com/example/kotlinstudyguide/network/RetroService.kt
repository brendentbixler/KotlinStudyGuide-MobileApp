package com.example.kotlinstudyguide.network

import com.example.kotlinstudyguide.models.AndroidRecyclerList
import com.example.kotlinstudyguide.models.KotlinRecyclerList
import com.example.kotlinstudyguide.models.ThirdRecyclerList
import retrofit2.http.GET

interface RetroService {

    @GET("study.json")
    suspend fun getKotlinDataFromAPI() : KotlinRecyclerList

    @GET("study.json")
    suspend fun getAndroidDataFromAPI() : AndroidRecyclerList

    @GET("study.json")
    suspend fun getThirdDataFromAPI() : ThirdRecyclerList

}