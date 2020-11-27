package com.example.api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.api.api.RetrofitClient
import com.example.api.api.model.JSONPlaceHolderData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycleView)
        val jsonPlaceHolder = RetrofitClient.JSONAPI
        jsonPlaceHolder?.JSONAPIAt?.enqueue(object : Callback<List<JSONPlaceHolderData?>?> {

            override fun onResponse(call: Call<List<JSONPlaceHolderData?>?>, response: Response<List<JSONPlaceHolderData?>?>) {
                val body = response.body()
                val recycleViewAdapter = RecycleViewAdapter(body as List<JSONPlaceHolderData>)
                recyclerView!!.setAdapter(recycleViewAdapter)
                val linearLayoutManager = LinearLayoutManager(applicationContext)
                recyclerView!!.setLayoutManager(linearLayoutManager)
                println("success")
            }

            override fun onFailure(call: Call<List<JSONPlaceHolderData?>?>, t: Throwable) {
                println("on failure error")
            }
        })
    }
}