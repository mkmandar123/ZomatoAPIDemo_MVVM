package com.example.zomatoapidemo.network.utils


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {
    private val authInterceptor = Interceptor {chain->
        val newUrl = chain.request().url()
            .newBuilder()
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val apiClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()



    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(apiClient)
        .baseUrl("https://developers.zomato.com/api/v2.1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    val egApi : ZApi = retrofit()
        .create(ZApi::class.java)

}