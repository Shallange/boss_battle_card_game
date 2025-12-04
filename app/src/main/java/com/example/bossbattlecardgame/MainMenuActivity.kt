package com.example.bossbattlecardgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bossbattlecardgame.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartGame.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        binding.btnBuildSelection.setOnClickListener{
        val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}