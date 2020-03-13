package com.example.kotlinexample.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    private final val BASEURL:String = ""

    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}