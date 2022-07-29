package com.acme.kotlinmvvm.ui.base

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acme.kotlinmvvm.data.repository.LoginRepository
import com.acme.kotlinmvvm.data.repository.MainRepository
import com.acme.kotlinmvvm.ui.main.viewmodel.LoginViewModel
import com.acme.kotlinmvvm.ui.main.viewmodel.MainViewModel


class MyViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {
    private var mApplication: Application? = null
    private var mParam: String? = null
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        }

        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }


}