package com.sl.sunnyweather.android.logic.network

import com.sl.sunnyweather.android.SunnyWeatherApplication
import com.sl.sunnyweather.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author  sunlong
 * @createTime  2020/09/13
 **/
interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>
}