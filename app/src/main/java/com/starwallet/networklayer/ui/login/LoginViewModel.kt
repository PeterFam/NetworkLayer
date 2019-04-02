package com.starwallet.networklayer.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.BaseViewModel
import javax.inject.Inject

class LoginViewModel
@Inject constructor() : ViewModel() {

    var emailError: MutableLiveData<Boolean> = MutableLiveData()

    var passwordError: MutableLiveData<Boolean> = MutableLiveData()

    fun validateData(email: String, password: String) {

        emailError.value = email.isEmpty()

        passwordError.value = password.isEmpty()

        if (emailError.value != true
            && passwordError.value != true
        ) {
            var loginRequest = LoginRequest(username = email, password = password)
            loginRequest(loginRequest)
        }

    }

    private fun loginRequest(loginRequest: LoginRequest) {

    }

    fun onEmailError(): LiveData<Boolean> = emailError


    override fun onCleared() {
        super.onCleared()

    }
}