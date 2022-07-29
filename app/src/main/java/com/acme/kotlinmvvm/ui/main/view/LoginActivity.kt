package com.acme.kotlinmvvm.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.acme.kotlinmvvm.R
import com.acme.kotlinmvvm.data.api.RetrofitService
import com.acme.kotlinmvvm.data.repository.LoginRepository
import com.acme.kotlinmvvm.databinding.ActivityLoginBinding
import com.acme.kotlinmvvm.ui.base.LoginViewModelFactory
import com.acme.kotlinmvvm.ui.base.MyViewModelFactory
import com.acme.kotlinmvvm.ui.main.viewmodel.LoginViewModel
import com.acme.kotlinmvvm.utils.SessionManager


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

  //  lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance1()
    lateinit var viewModel: LoginViewModel

   // private val retrofitService = RetrofitService.getInstance()
    var sessionManager:SessionManager?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        println("hii======")
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("hii======111111")
        binding.textView2.setOnClickListener {
           println("loginerrorrresponse")
            viewModel = ViewModelProvider(this, LoginViewModelFactory(LoginRepository(retrofitService))).get(
                LoginViewModel::class.java)

            viewModel.loginResp.observe(this, Observer {
               // Log.d(TAG, "onCreate: $it")
               // adapter.setMovieList(it)
               println("loginresponse====$it")
            })

            viewModel.errorMessage.observe(this, Observer {
               println("loginerrorrresponse====$it")
            })

            viewModel.getLogin("testacme","123456","dggsg")
          //  viewModel.getAllMovies()


        }
       // sessionManager.setUserid();
    }
}