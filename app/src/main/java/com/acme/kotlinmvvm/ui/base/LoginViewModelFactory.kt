package com.acme.kotlinmvvm.ui.base

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.acme.kotlinmvvm.data.repository.LoginRepository
import com.acme.kotlinmvvm.ui.main.viewmodel.LoginViewModel

class LoginViewModelFactory(private val repository: LoginRepository): ViewModelProvider.Factory {
    private var mApplication: Application? = null
    private var mParam: String? = null
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.repository) as T
        }

        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }


}