package com.example.proyectoandroidudemy.api

import com.example.proyectoandroidudemy.BASE_URL
import com.example.proyectoandroidudemy.Dog
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface  ApiService {
    @GET("dogs")
    suspend fun getAllDogs(): List<Dog>
}

object  DogsApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}