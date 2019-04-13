package com.starwallet.networklayer.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.starwallet.networklayer.R
import com.starwallet.networklayer.data.model.AppResponses
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.helpers.extention.failure
import com.starwallet.networklayer.helpers.extention.observe
import com.starwallet.networklayer.helpers.extention.showSnackBar
import com.starwallet.networklayer.helpers.extention.viewModel
import com.starwallet.networklayer.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Result.Companion.failure

class LoginActivity : BaseActivity(), View.OnClickListener {


    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initView()
    }

    private fun initView() {
        loginViewModel = viewModel(viewModelFactory) {
            observe(loginResponse, ::onLoginResponse)
            observe(emailError, ::onErrorEmail)
            observe(passwordError, ::onErrorPassword)
            observe(loadingProgress, ::onLoading)
            failure(failure, ::handleFailure)
        }

        submitBtn.setOnClickListener(this)
    }

    private fun onLoginResponse(appResponses: AppResponses?) {
        Log.d("Logiiiiin", appResponses.toString())
    }

    private fun onLoading(show: Boolean?) {
        when (show) {
            true -> showProgress()
            false -> dismissProgress()
        }
    }

    override fun onClick(v: View?) {
        loginViewModel.validateData(emailEditText.text.toString(), passwordEditText.text.toString())
    }

    private fun onErrorPassword(error: Boolean?) {
        when (error) {
            true -> showSnackBar("Email Can't be empty")
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
            is Failure.Unauthorizes ->{
                showSnackBar("Unauthorized User")
            }
        }
    }

}



