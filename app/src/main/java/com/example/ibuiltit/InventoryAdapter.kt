package com.example.ibuiltit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InventoryAdapter(private val context: Context, private val inventNum: Int) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {
    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(position: Int){

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = inventNum;

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

    }
}
