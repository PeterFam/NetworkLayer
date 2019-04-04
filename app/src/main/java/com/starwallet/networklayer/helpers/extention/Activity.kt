package com.starwallet.networklayer.helpers.extention

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.starwallet.networklayer.ui.BaseActivity


inline fun <reified T : ViewModel> BaseActivity.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit): T {
    val vm = androidx.lifecycle.ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}

fun Activity.showTost(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun Activity.showSnackBar(msg: String) {
    Snackbar.make(window.decorView.rootView, msg, Snackbar.LENGTH_LONG).show()
}