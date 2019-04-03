package com.starwallet.networklayer.ui.login

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.starwallet.networklayer.R
import com.starwallet.networklayer.ui.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()


        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        loginViewModel.onEmailError().observe(this, Observer {

        })
    }

    private fun initView() {

    }





}



