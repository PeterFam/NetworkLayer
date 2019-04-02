package com.starwallet.networklayer.helpers.extention

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starwallet.networklayer.ui.BaseActivity


inline fun <reified T : ViewModel> BaseActivity.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = androidx.lifecycle.ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}