package com.acme.kotlinmvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acme.kotlinmvvm.data.model.Movie
import com.acme.kotlinmvvm.data.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()
    val loginResp = MutableLiveData<String>()
    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


 /*   fun getLogin(userName:String,password:String) {

        val response = repository.getLogin(userName,password)
        response.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                loginResp.postValue(response.body())
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }*/
}