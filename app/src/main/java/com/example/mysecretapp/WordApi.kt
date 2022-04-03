package com.example.mysecretapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WordApi {

    @GET("/todos")
    suspend fun getAllWord(): Response<List<Word>>

}