package com.example.proyectoandroidudemy.doglist

import com.example.proyectoandroidudemy.Dog
import com.example.proyectoandroidudemy.api.DogsApi.retrofitService
import com.example.proyectoandroidudemy.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs() : List<Dog>{
        return (Dispatchers.IO){
           val dogListApiResponse = retrofitService.getAllDogs()
           val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}