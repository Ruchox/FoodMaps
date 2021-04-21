package com.example.foodmaps.data.datasource

import com.example.foodmaps.R
import com.example.foodmaps.data.model.Preference

class PreferenceDataSource {
    fun loadPreferences(): List<Preference>{
        return listOf<Preference>(
                Preference(R.string.preference1),
                Preference(R.string.preference2),
                Preference(R.string.preference3)
        )
    }
}