package com.example.proyectoandroidudemy.api.dto

import com.example.proyectoandroidudemy.Dog

class DogDTOMapper {

    private fun fromDogDTOToDogDomain(dogDTO: DogDTO): Dog {
        return Dog(dogDTO.id,dogDTO.index,dogDTO.name,dogDTO.type,dogDTO.heightFemale,dogDTO.heightMale,
        dogDTO.imageUrl,dogDTO.lifeExpectancy,dogDTO.temperament,dogDTO.weightMale,dogDTO.weightFemale)
    }

    fun fromDogDTOListToDogDomainList(dogDTOList: List<DogDTO>): List<Dog>{
        return dogDTOList.map { fromDogDTOToDogDomain(it) }
    }

}