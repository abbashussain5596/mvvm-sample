package com.example.kotlinexample.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinexample.R
import com.example.kotlinexample.databinding.ActivityMainBinding
import com.example.kotlinexample.model.LoginResponse
import com.example.kotlinexample.viewmodel.LoginViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        dataBinding.activity = this

        dataBinding.loginActivityViewModel = loginViewModel

        loginViewModel.loginResponseLiveData.observe(
            this,
            Observer<LoginResponse> { loginResponse: LoginResponse? ->

                Toast.makeText(applicationContext, loginResponse!!.getMessage(), Toast.LENGTH_SHORT)
                    .show()

            })

        loginViewModel.errorLiveData.observe(this, Observer<String> { error: String? ->

            Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

        })

    }

}

