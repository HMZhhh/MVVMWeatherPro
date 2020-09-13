package com.sl.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author  sunlong
 * @createTime  2020/09/13
 **/

class SunnyWeatherApplication :Application(){
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
        const val TOKEN = ""
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }
}