package com.example.zomatoapidemo.network.utils

import android.provider.ContactsContract
import kotlinx.coroutines.Deferred
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.*


interface ZApi {
    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("locations")
    fun getLocations(@Query("query")location:String): Deferred<Response< Object>>

    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("search")
    fun findLocation(@Query("entity_id")entityid:Int, @Query("entity_type")ent:String): Deferred<Response<Object>>

}
