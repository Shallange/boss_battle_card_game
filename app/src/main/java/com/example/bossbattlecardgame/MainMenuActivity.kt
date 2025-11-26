package com.example.bossbattlecardgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_menu)
        val btnSettings = findViewById<Button>(R.id.btnBuildSelection)
        val btnStartGame = findViewById<Button>(R.id.btnStartGame)

        btnStartGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener{
        val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}