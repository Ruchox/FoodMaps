package com.example.foodmaps.data.datasource

import com.example.foodmaps.R
import com.example.foodmaps.data.model.Preference
import java.sql.*
import java.util.*
/*
    Handles loading of preference list for PreferencesActivity.
 */
class PreferenceDataSource {
    fun loadPreference() : List<Preference>{

        return listOf<Preference>(
                Preference(R.string.preference1),
                Preference(R.string.preference2),
                Preference(R.string.preference3)
        )
    }
}

