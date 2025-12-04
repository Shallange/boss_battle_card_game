package com.example.bossbattlecardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bossbattlecardgame.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity(){

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToMainMenu.setOnClickListener {
            finish()
        }
        val prefs = getSharedPreferences("game_prefs", MODE_PRIVATE)

        binding.radioDamage.setOnClickListener {
            prefs.edit().putString("player_build", PlayerBuild.DAMAGE.name).apply()
        }
        binding.radioDefensive.setOnClickListener {
            prefs.edit().putString("player_build", PlayerBuild.DEFENSIVE.name).apply()
        }
        binding.radioBalanced.setOnClickListener {
            prefs.edit().putString("player_build", PlayerBuild.BALANCED.name).apply()
        }
        binding.radioHeal.setOnClickListener {
            prefs.edit().putString("player_build", PlayerBuild.HEALER.name).apply()
        }


    }
}
