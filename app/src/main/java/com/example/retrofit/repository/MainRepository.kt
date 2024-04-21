package com.example.retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.api.ResultApi
import com.example.retrofit.model.DataResult

class MainRepository(private val api : ResultApi) {

    private val resultLiveData = MutableLiveData<DataResult>()

    val result : LiveData<DataResult>
        get() = resultLiveData

    suspend fun getData() {
        val res = api.getResult()
        if (res.body() != null) {
            resultLiveData.postValue(res.body())
        }
    }

}