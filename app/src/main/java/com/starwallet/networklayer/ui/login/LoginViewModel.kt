package com.starwallet.networklayer.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.starwallet.networklayer.ui.BaseViewModel

class LoginViewModel : BaseViewModel() {

    public var emailError: MutableLiveData<Boolean> = MutableLiveData()

    private var passwordError: MutableLiveData<Boolean> = MutableLiveData()

    fun validateData(email: String, password: String) {

        emailError.value = email.isEmpty()

        passwordError.value = password.isEmpty()

        if (emailError.value != true
            && passwordError.value != true
        ) {
            loginRequest()
        }
    }

    private fun loginRequest() {

    }

    public fun getEmailError() : LiveData<Boolean>{
        return emailError
    }

}