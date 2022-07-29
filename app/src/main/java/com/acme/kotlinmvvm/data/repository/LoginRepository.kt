package com.acme.kotlinmvvm.data.repository

import com.acme.kotlinmvvm.data.api.RetrofitService

class LoginRepository constructor(private val retrofitService: RetrofitService) {


    fun getLogin(userName: String, password: String, GUID: String) = retrofitService.getLogin(userName,
        password,
        GUID
    )
    fun registerDevice() = retrofitService.registerDevice("NEW")
  //  fun registerDevice()=retrofitService.registerDevice("")
}