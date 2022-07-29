package com.acme.kotlinmvvm.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.acme.kotlinmvvm.R
import com.acme.kotlinmvvm.data.api.RetrofitService
import com.acme.kotlinmvvm.data.repository.LoginRepository
import com.acme.kotlinmvvm.ui.base.LoginViewModelFactory
import com.acme.kotlinmvvm.ui.main.viewmodel.LoginViewModel
import com.acme.kotlinmvvm.utils.SessionManager

class SplashActivity : AppCompatActivity() {
    private val retrofitService = RetrofitService.getInstance1()
    lateinit var viewModel: LoginViewModel

    // private val retrofitService = RetrofitService.getInstance()

    var sessionMnager:SessionManager?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sessionMnager= SessionManager(applicationContext )
        if(sessionMnager!!.getGUID()!=null)
        {
            if(sessionMnager!!.getUserid()!=null)
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Handler().postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 3000)
            }
        }else {
            viewModel = ViewModelProvider(this, LoginViewModelFactory(LoginRepository(retrofitService))).get(
                LoginViewModel::class.java)



            viewModel.guidResp.observe(this, Observer {
                // Log.d(TAG, "onCreate: $it")
                // adapter.setMovieList(it)
                println("guidresponse====$it")
            })

            viewModel.errorMessage.observe(this, Observer {
                println("guidresponseerorrresponse====$it")
            })

            viewModel.registerDevice()
        }
    }
}