package com.example.foodmaps.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmaps.R
import com.example.foodmaps.data.model.Preference

/*
    Adapts the information that will be used for the preference pages recycler view.
 */
class ItemAdapter(private val context : Context,
                  private val dataset: List<Preference>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val checkBox: CheckBox = view.findViewById<CheckBox>(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Create a new view.
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,parent,false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.checkBox.text = context.resources.getString(item.preference)
    }

    override fun getItemCount(): Int = dataset.size

}