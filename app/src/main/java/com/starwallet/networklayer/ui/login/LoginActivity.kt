package com.starwallet.networklayer.ui.login

import android.os.Bundle
import com.starwallet.networklayer.R
import com.starwallet.networklayer.helpers.extention.viewModel
import com.starwallet.networklayer.ui.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        loginViewModel = viewModel(viewModelFactory){
        }
    }

    private fun initView() {


    }





}



