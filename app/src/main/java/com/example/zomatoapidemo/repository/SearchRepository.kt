package com.example.zomatoapidemo.repository

import com.example.zomatoapidemo.network.utils.ZApi
import com.google.gson.Gson
import com.squareup.moshi.Json
import org.json.JSONArray
import org.json.JSONObject

class SearchRepository(private val api: ZApi) {
    suspend fun getLocations(location:String): String?{
        var response = api.getLocations(location).await()
        return response.body().toString()
    }

    suspend fun findLocation(entityid:Int): Any?{
        var response = api.findLocation(entityid,"city").await()
        return Gson().toJson(response.body())
    }
}