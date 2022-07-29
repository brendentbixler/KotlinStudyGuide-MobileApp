package com.example.kotlinstudyguide.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinstudyguide.models.AndroidRecyclerList
import com.example.kotlinstudyguide.models.KotlinRecyclerList
import com.example.kotlinstudyguide.network.RetroInstance
import com.example.kotlinstudyguide.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    lateinit var kotlinRecyclerListLiveData : MutableLiveData<KotlinRecyclerList> /** For Kotlin call */
    lateinit var androidRecyclerListLiveData : MutableLiveData<AndroidRecyclerList> /** For Android call */

    init {
        kotlinRecyclerListLiveData = MutableLiveData() /** For Kotlin call */
        androidRecyclerListLiveData = MutableLiveData() /** For Android call */
    }

    /**
     * Get Observer for Kotlin
     */
    fun getKotlinRecyclerListObserver(): MutableLiveData<KotlinRecyclerList> {
        return kotlinRecyclerListLiveData
    }

    /**
     * Get Observer for Android
     */
    fun getAndroidRecyclerListObserver(): MutableLiveData<AndroidRecyclerList> {
        return androidRecyclerListLiveData
    }

    /**
     * Make the API call on the IO thread and not the main thread
     * For the Kotlin Questions
     */
    fun makeKotlinApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getKotlinDataFromAPI()
            kotlinRecyclerListLiveData.postValue(response)
        }
    }

    /**
     * Make the API call on the IO thread and not the main thread
     * For the Kotlin Questions
     */
    fun makeAndroidApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getAndroidDataFromAPI()
            androidRecyclerListLiveData.postValue(response)
        }
    }

}