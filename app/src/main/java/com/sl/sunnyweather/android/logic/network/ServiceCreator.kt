package com.sl.sunnyweather.android.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * retrofit 构建器
 * @author  sunlong
 * @createTime  2020/09/13
 **/

object ServiceCreator {
    private const val BASE_URL="https://api.caiyunapp.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>):T = retrofit.create(serviceClass)

    inline fun <reified T>create():T = create(T::class.java)
}