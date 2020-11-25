package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.RecycleViewAdapter.ListViewHolder
import com.example.api.api.model.JSONPlaceHolderData

class RecycleViewAdapter(private val jsonPlaceHolderDataList: List<JSONPlaceHolderData>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.json_item_layout, parent, false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val v = jsonPlaceHolderDataList[position].userId
        holder.userID.text = jsonPlaceHolderDataList[position].userId.toString()
        holder.id.text = jsonPlaceHolderDataList[position].id.toString()
        holder.title.text = jsonPlaceHolderDataList[position].title.toString()
        holder.body.text = jsonPlaceHolderDataList[position].body.toString()
    }

    override fun getItemCount(): Int {
        return jsonPlaceHolderDataList.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userID: TextView
        val id: TextView
        val title: TextView
        val body: TextView

        init {
            userID = itemView.findViewById(R.id.userIdTextView)
            id = itemView.findViewById(R.id.idTextView)
            title = itemView.findViewById(R.id.titleTextView)
            body = itemView.findViewById(R.id.bodyTextView)
        }
    }
}