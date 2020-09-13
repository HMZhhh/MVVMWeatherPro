package com.sl.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sl.sunnyweather.android.logic.model.Place
import com.sl.sunnyweather.android.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import java.lang.RuntimeException

/**
 *  一般在仓库层中定义的方法 为了能将异步获取的数据以响应式编程的方式通知给上一层 通常会返回一个liveData对象
 * @author  sunlong
 * @createTime  2020/09/13
 **/
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO)
    {
        var result = try {
            val  placeResponse = SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status=="ok")
            {
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}