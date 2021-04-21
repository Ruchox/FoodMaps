package com.example.foodmaps.data.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmaps.R
import com.example.foodmaps.data.datasource.ResultDataSource
import com.example.foodmaps.data.adapter.ResultAdapter

class ResultsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Loading Restaurants to activity
        val restaurantResults = ResultDataSource().loadResults()
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_result)
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(false)
        recyclerView.adapter = ResultAdapter(this, restaurantResults)



    }
}