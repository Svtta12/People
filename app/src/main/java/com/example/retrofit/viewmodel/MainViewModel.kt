package com.example.retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.DataResult
import com.example.retrofit.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {


    init {
        viewModelScope.launch (Dispatchers.IO) {
            mainRepository.getData()

        }
    }

    val result : LiveData<DataResult>
        get() = mainRepository.result

}