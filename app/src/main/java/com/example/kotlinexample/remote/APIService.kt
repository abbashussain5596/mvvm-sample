package com.example.kotlinexample.remote

import com.example.kotlinexample.model.LoginModel
import com.example.kotlinexample.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("")
    fun login(@Body body: LoginModel?): Call<LoginResponse>

}