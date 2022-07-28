package com.example.kotlinstudyguide.network

import com.example.kotlinstudyguide.models.RecyclerList
import retrofit2.http.GET

interface RetroService {

    @GET("study.json")
    suspend fun getDataFromAPI() : RecyclerList

}