package com.example.foodmaps.data.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmaps.R
import com.example.foodmaps.data.datasource.PreferenceDataSource
import com.example.foodmaps.data.adapter.ItemAdapter

class PreferencesActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        // Loads food preferences to scene
        val foodPreferences = PreferenceDataSource().loadPreferences()
        recyclerView = findViewById<RecyclerView>(R.id.recycler_view_preference)
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ItemAdapter(this, foodPreferences)

        val submitButton = findViewById<Button>(R.id.preference_submit_button)
        submitButton.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            startActivity(intent)
        }
        // Changes scene title
        title = "Preferences"
    }
}