package com.example.kotlinexample.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlinexample.model.LoginModel
import com.example.kotlinexample.model.LoginResponse
import com.example.kotlinexample.remote.APIService
import com.example.kotlinexample.remote.Client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    final var errorLiveDate: MutableLiveData<String> = MutableLiveData()
    final var loginResponseLiveData: MutableLiveData<LoginResponse> = MutableLiveData()

    public fun login(login: LoginModel): MutableLiveData<LoginResponse> {

        val client: Client = Client()

        val service: APIService = client.retrofit().create(APIService::class.java)

        val call: Call<LoginResponse> = service.login(login)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                errorLiveDate.value = t.message

            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                if (response.isSuccessful) {

                    if (response.body()!!.getCode() == 200) {

                        loginResponseLiveData.value = response.body()

                    } else {

                        errorLiveDate.value = response.body()!!.getMessage()

                    }

                } else {

                    errorLiveDate.value = response.message()

                }

            }

        })

        return loginResponseLiveData

    }

    public fun getErrorMessage(): MutableLiveData<String> {

        return errorLiveDate;

    }

    public fun getLoginResponse(): MutableLiveData<LoginResponse> {

        return loginResponseLiveData

    }


}