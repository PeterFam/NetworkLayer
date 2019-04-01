package com.starwallet.networklayer.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.starwallet.networklayer.AndroidApplication
import com.starwallet.networklayer.di.ApplicationComponent
import com.starwallet.networklayer.helpers.LoadingProgress
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(){

//    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
//        (application as AndroidApplication).appComponent
//    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private var loadingProgress: LoadingProgress = LoadingProgress()

    protected fun showProgress() = loadingProgress.show(this.supportFragmentManager, "show")

    protected fun dismissProgress() = loadingProgress.dismissAllowingStateLoss()

}