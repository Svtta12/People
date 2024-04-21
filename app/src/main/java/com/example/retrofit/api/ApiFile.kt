package com.example.retrofit.api

import com.example.retrofit.model.DataResult
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object ApiFile {

    val baseURL = "https://randomuser.me/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    }
}

interface ResultApi {
    @GET("api/")
    suspend fun getResult() : Response<DataResult>
}