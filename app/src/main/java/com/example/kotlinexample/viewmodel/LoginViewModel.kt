package com.example.kotlinexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinexample.model.LoginModel
import com.example.kotlinexample.model.LoginResponse
import com.example.kotlinexample.repository.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private final var loginModel: LoginModel

    var loginRepository: LoginRepository = LoginRepository();

    public var loginModelLiveData: MutableLiveData<LoginModel>
    public var loginResponseLiveData : MutableLiveData<LoginResponse>
    public var errorLiveData : MutableLiveData<String>


    init {

        errorLiveData = loginRepository.getErrorMessage()

        loginResponseLiveData = loginRepository.getLoginResponse()

        loginModelLiveData = MutableLiveData()

        loginModel= LoginModel()

        loginModelLiveData.value = loginModel


    }

    public fun onLoginClicked(){

        loginRepository.login(loginModel)

    }


}