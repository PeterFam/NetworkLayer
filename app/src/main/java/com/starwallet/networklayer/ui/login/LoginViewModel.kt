package com.starwallet.networklayer.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.request.LoginRequest
import com.starwallet.networklayer.ui.BaseViewModel
import javax.inject.Inject

class LoginViewModel
@Inject constructor(private val loginUseCase: LoginUseCase)
    : BaseViewModel() {


    var emailError: MutableLiveData<Boolean> = MutableLiveData()
    var passwordError: MutableLiveData<Boolean> = MutableLiveData()
    var loginResponse: MutableLiveData<AppResponses> = MutableLiveData()

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

    private  fun loginRequest(loginRequest: LoginRequest) {
        loadingProgress.value = true
        loginUseCase(LoginUseCase.Params(loginRequest)) {
            it.either(::handleFailure, ::handleLoginResponse)
        }
    }


    private fun handleLoginResponse(appResponse: AppResponses){
        loadingProgress.value = false
        this.loginResponse.value = appResponse
    }

    fun onEmailError(): LiveData<Boolean> = emailError

}