package com.example.zomatoapidemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import org.json.JSONObject

class RecyclerViewAdapter(val restList:MutableList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return restList.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bindItems(JSONObject(restList[position]).getString("name"),JSONObject(restList[position]).getString("location"))
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(restName: String,restAdd: String) {
            itemView.textView.text = restName
//            itemView.address.text=restAdd
        }
    }
}