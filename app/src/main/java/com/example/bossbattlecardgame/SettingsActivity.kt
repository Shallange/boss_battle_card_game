package com.example.bossbattlecardgame

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnMainMenu = findViewById<Button>(R.id.btnBackToMainMenu)

        btnMainMenu.setOnClickListener {
            finish()
        }
    }
}
