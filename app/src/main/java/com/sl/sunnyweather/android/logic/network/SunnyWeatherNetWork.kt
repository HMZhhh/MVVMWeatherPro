package com.sl.sunnyweather.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 统一的网络数据源访问入口 对所有的API进行封装
 * @author  sunlong
 * @createTime  2020/09/13
 **/
object SunnyWeatherNetWork {
    //创建了一个placeService 接口的动态代理对象
    private val placeService = ServiceCreator.create<PlaceService>()
    //定义一个函数--声明成挂起函数
    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine { continuation ->
            enqueue(object :Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    val body = response.body()
                    if (body!=null) {
                        continuation.resume(body)
                    }
                    else continuation.resumeWithException(RuntimeException(" response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    continuation.resumeWithException(t)
                }
            })
        }
    }

}