package com.starwallet.networklayer.ui.login

import android.os.Bundle

import com.starwallet.networklayer.R
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.helpers.extention.failure
import com.starwallet.networklayer.helpers.extention.observe
import com.starwallet.networklayer.helpers.extention.showSnackBar
import com.starwallet.networklayer.helpers.extention.viewModel
import com.starwallet.networklayer.ui.BaseActivity
import kotlin.Result.Companion.failure

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initView()

    }

    private fun initView() {
        loginViewModel = viewModel(viewModelFactory) {
            observe(emailError, ::onErrorEmail)
            observe(passwordError, ::onErrorPassword)
            failure(failure, ::handleFailure)
        }
    }

    private fun onErrorPassword(error: Boolean?) {
        when (error) {
            true -> showSnackBar("Password Can't be empty")
        }
    }

    private fun onErrorEmail(error: Boolean?) {
        when (error) {
            true -> showSnackBar("Password Can't be empty")
        }
    }


    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> {
                showSnackBar("Network Error")
            }
            is Failure.ServerError -> {
                showSnackBar("Server Error")
            }
        }
    }

}



