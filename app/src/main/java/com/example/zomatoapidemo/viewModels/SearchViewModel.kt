package com.example.zomatoapidemo.viewModels


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zomatoapidemo.model.RestClass
import com.example.zomatoapidemo.network.utils.ApiFactory
import com.example.zomatoapidemo.repository.SearchRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import org.json.JSONArray
import org.json.JSONObject
import kotlin.coroutines.CoroutineContext


class SearchViewModel: ViewModel() {
    private  val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)
    private val SearchRepository : SearchRepository =
        SearchRepository(
            ApiFactory.egApi
        )

    var locationsData = MutableLiveData<JSONObject?>()
    var data=MutableLiveData<JSONArray>()
    var listRest= MutableLiveData<MutableList<String>>()
    fun fetchLocations(location:String){
        scope.launch {
            val locations = SearchRepository.getLocations(location)
            locationsData.postValue(JSONObject(locations))
        }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getLocation(entityid:Int){
        scope.launch {
            val locations = SearchRepository.findLocation(entityid)

            data.postValue(JSONObject(locations.toString()).getJSONArray("restaurants"))
        }
    }

    }



    fun cancelAllRequests() = coroutineContext.cancel()