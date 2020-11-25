package com.example.api.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
    private var jsonPlaceHolder: JSONPlaceHolder? = null
    private val instance: Retrofit?
        private get() {
            if (retrofit == null) {
                val okHttpClient = OkHttpClient().newBuilder().build()
                retrofit = Retrofit.Builder()
                        .client(okHttpClient)
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit
        }
    val JSONAPI: JSONPlaceHolder?
        get() {
            if (jsonPlaceHolder == null) {
                jsonPlaceHolder = instance!!.create(JSONPlaceHolder::class.java)
            }
            return jsonPlaceHolder
        }
}