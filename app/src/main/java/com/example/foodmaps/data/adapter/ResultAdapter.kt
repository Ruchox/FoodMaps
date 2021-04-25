package com.example.foodmaps.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmaps.R
import com.example.foodmaps.data.model.Result

/*
    Adapts the information that will be used for the Resturaunt results page's recycler view.
 */
class ResultAdapter(private val context: Context, private val dataset: List<Result>)
    :RecyclerView.Adapter<ResultAdapter.ResultViewHolder>(){
        class ResultViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val viewBtn: Button = view.findViewById<Button>(R.id.restaurant_choice)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        // Create a new view.
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_result,parent,false)
        return ResultViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val item = dataset[position]
        holder.viewBtn.text = item.result

    }

    override fun getItemCount(): Int = dataset.size

}