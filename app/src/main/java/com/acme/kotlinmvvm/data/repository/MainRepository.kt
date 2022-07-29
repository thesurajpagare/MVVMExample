package com.acme.kotlinmvvm.data.repository

import com.acme.kotlinmvvm.data.api.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()

    //fun getLogin(userName: String, password: String, GUID: String) = retrofitService.getLogin("","","")
    //fun registerDevice()=retrofitService.registerDevice("")
}