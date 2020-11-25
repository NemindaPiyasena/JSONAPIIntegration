package com.example.api.api

import com.example.api.api.model.JSONPlaceHolderData
import retrofit2.Call
import retrofit2.http.GET

interface JSONPlaceHolder {
    @get:GET("posts")
    val JSONAPIAt: Call<List<JSONPlaceHolderData?>?>?
}