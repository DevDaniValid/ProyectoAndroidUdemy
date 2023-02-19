package com.example.proyectoandroidudemy.doglist

import com.example.proyectoandroidudemy.Dog
import com.example.proyectoandroidudemy.api.DogsApi.retrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs() : List<Dog>{
        return (Dispatchers.IO){
           val dogListApiResponse = retrofitService.getAllDogs()
            dogListApiResponse.data.dogs
        }
    }
}