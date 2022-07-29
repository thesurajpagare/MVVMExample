package com.acme.kotlinmvvm.data.api

import com.acme.kotlinmvvm.data.model.Movie
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface RetrofitService {
   // user/getDevicetype

    @POST("user/registerDevice")
    @FormUrlEncoded
    fun registerDevice(@Field("GUID") id :String ) : Call<String>

    @POST("user/login")
    @FormUrlEncoded
    fun getLogin(@Field("username") id :String , @Field("password")  password:String,@Field("GUID")  GUID:String) : Call<String>

    @GET("movielist.json")
    fun getAllMovies() : Call<List<Movie>>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

        fun getInstance1() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://app.iotglobal.co.za/app/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}