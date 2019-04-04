package com.starwallet.networklayer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starwallet.networklayer.data.remote.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    val scope = CoroutineScope(coroutineContext)

    var failure: MutableLiveData<Failure> = MutableLiveData()

    var loadingProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun onLoadingProgress(show: Boolean) : LiveData<Boolean> = loadingProgress

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
    }


}