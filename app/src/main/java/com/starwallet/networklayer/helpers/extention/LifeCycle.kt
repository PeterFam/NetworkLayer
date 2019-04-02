package com.starwallet.networklayer.helpers.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.starwallet.networklayer.data.remote.Failure
import com.starwallet.networklayer.ui.BaseViewModel

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) =
    liveData.observe(this, Observer(body))