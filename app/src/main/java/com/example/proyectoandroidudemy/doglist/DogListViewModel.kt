package com.example.proyectoandroidudemy.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectoandroidudemy.Dog
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val dogRepository = DogRepository()

    init {
        dowloadDogs()
    }

    private fun dowloadDogs() {
        viewModelScope.launch() {
            _dogList.value = dogRepository.downloadDogs()
        }
    }
}