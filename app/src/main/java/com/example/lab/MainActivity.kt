package com.example.lab

import TrailListFragment
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab.ui.theme.MyApplicationTheme
import com.example.lab.TrailListFragment


val trails = listOf(
    Trail(
        "Szlak Górski",
        listOf("Przełęcz", "Szczyt", "Schronisko"),
        "Opis szlaku górskiego...",
        listOf(60, 90, 45)
    ),
    Trail(
        "Szlak Nadmorski",
        listOf("Plaża", "Klif", "Latarnia"),
        "Opis szlaku nadmorskiego...",
        listOf(30, 45, 20)
    )
)

class MainActivity : ComponentActivity(), TrailListFragment.OnTrailSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TrailListFragment())
                .commit()
        }
    }

    override fun onTrailSelected(trailName: String) {
        val detailsFragment = TrailDetailsFragment.newInstance(trailName)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}