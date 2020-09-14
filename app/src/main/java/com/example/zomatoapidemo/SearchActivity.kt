package com.example.zomatoapidemo

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.zomatoapidemo.viewModels.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer

class SearchActivity : AppCompatActivity() {
    private lateinit var searchViewModel: SearchViewModel
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        searchViewModel.locationsData.observe(this, Observer {
            var jsonArray=JSONArray(it?.getString("location_suggestions")).getJSONObject(0).getString("entity_id").toInt()
            searchViewModel.getLocation(jsonArray)

        })

        searchViewModel.data.observe(this, Observer {
            var list= mutableListOf<String>()
            for (i in 0 until it.length()) {
                val mJsonObject: JSONObject = it.getJSONObject(i)
                Log.d("OutPut", mJsonObject.getString("restaurant"))
                list.add(mJsonObject.getString("restaurant"))
            }
            searchViewModel.listRest.postValue(list)
            val rec=RecyclerViewAdapter(list)
            recycler.adapter=rec

        })

//        searchViewModel.listRest.observe(this, Observer {
//
//        })

        setContentView(R.layout.activity_search)

        button.setOnClickListener {
            searchViewModel.fetchLocations(editTextTextPersonName.text.toString())
        }
    }
}