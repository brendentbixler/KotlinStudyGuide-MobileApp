package com.example.kotlinstudyguide.network

import com.example.kotlinstudyguide.models.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

//    @GET("/study.json")
//    suspend fun getDataFromAPI() : RecyclerList

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String): RecyclerList

}