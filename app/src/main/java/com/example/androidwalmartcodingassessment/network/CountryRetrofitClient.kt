package com.example.androidwalmartcodingassessment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountryRetrofitClient {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: CountryApiService by lazy {
        retrofit.create(CountryApiService::class.java)
    }
}