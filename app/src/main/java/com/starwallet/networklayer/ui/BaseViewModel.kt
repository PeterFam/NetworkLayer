package com.starwallet.networklayer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.starwallet.networklayer.data.remote.Failure


abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<Failure> = MutableLiveData()

    var loadingProgress: MutableLiveData<Boolean> = MutableLiveData()

    fun onLoadingProgress(show: Boolean) : LiveData<Boolean> = loadingProgress

    override fun onCleared() {
        super.onCleared()
       // parentJob.cancel()
    }

    protected fun handleFailure(failure: Failure) {
        loadingProgress.value = false
        this.failure.value = failure
    }


}