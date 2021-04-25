package com.example.foodmaps.data.datasource

import com.example.foodmaps.R
import com.example.foodmaps.data.model.Result
/*
    Handles loading of restaurants list for ResultsActivity.
 */

class ResultDataSource {
    // Creates list of results that will be passed into the ResultDataSource class.
    fun loadResults(): MutableList<Result>{
        var list : MutableList<Result> = mutableListOf()
        for (i in 1..10) {
            list.add(Result("Restaurant $i"))
        }



        return list
    }
}