package com.starwallet.networklayer.ui.login

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.starwallet.networklayer.R
import com.starwallet.networklayer.helpers.extention.viewModel

import com.starwallet.networklayer.ui.BaseActivity
import javax.inject.Inject
import kotlin.math.log

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        loginViewModel = viewModel(viewModelFactory){
            ob
        }
    }

    private fun initView() {

        loginViewModel.onEmailError().observe(this, )
    }





}



