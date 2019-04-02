package com.starwallet.networklayer.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starwallet.networklayer.ui.BaseViewModel
import javax.inject.Inject

class LoginViewModel
    @Inject constructor(): ViewModel() {

    var emailError: MutableLiveData<Boolean> = MutableLiveData()

    var passwordError: MutableLiveData<Boolean> = MutableLiveData()

    fun validateData(email: String, password: String) {

        emailError.value = email.isEmpty()

        passwordError.value = password.isEmpty()

        if (emailError.value != true
            && passwordError.value != true)
            loginRequest()

    }
    private fun loginRequest() {

    }

    fun onEmailError() : LiveData<Boolean> =  emailError


}