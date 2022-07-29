package com.acme.kotlinmvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acme.kotlinmvvm.data.repository.LoginRepository
import com.acme.kotlinmvvm.data.repository.MainRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val repository: LoginRepository)  : ViewModel() {

   // val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    val loginResp = MutableLiveData<String>()
    val guidResp = MutableLiveData<String>()
   /* fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }*/


    fun getLogin(userName:String,password:String,GUID:String) {

        val response = repository.getLogin(userName,password,GUID)
        response.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("hiii$response")
                loginResp.postValue(response.body())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("hiii${t.localizedMessage}")
                errorMessage.postValue(t.message)
            }
        })



    }


    fun registerDevice() {

        val response = repository.registerDevice()
        response.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                println("hiii$response")
                guidResp.postValue(response.body())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                println("hiii${t.localizedMessage}")
                errorMessage.postValue(t.message)
            }
        })



    }
}