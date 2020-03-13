package com.example.kotlinexample.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.kotlinexample.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginModel : BaseObservable() {


    @get:Bindable
    @SerializedName("email")
    @Expose
    var email: String? = null
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
        }


    @get:Bindable
    @SerializedName("password")
    @Expose
    var password: String? = null
        set(password) {
            field = password
            notifyPropertyChanged(BR.password)
        }

}