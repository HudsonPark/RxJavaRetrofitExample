package com.example.rxjavaretrofitexample

import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkManager {

    val naverApi by lazy { retrofit.create<NaverApi>() }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://openapi.naver.com")
            .build()
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.request()
                    .newBuilder()
                    .addHeader("X-Naver-Client-Id", "y5_NNkPCE9ItVzDN4SYN")
                    .addHeader("X-Naver-Client-Secret", "dVE5yklLXs")
                    .build()
                    .let {
                        chain.proceed(it)
                    }
            }
            .build()
    }
}