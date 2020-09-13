package com.sl.sunnyweather.android.ui.place

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sl.sunnyweather.android.logic.Repository
import com.sl.sunnyweather.android.logic.model.Place

/**
 * @author  sunlong
 * @createTime  2020/09/13
 **/
class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    //城市数据进行缓存
    val placeList = ArrayList<Place>()

    //观察这个对象
    val placeLiveData = Transformations.switchMap(searchLiveData){
        query->Repository.searchPlaces(query)
    }

    fun searchPlaces(query:String){
        searchLiveData.value = query
    }

}