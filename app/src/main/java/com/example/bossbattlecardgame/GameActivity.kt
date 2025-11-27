package com.example.bossbattlecardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private val bosses = listOf(
        Boss("Infernal Dreadknight",340,R.drawable.infernaldreadknight),
        Boss("Emberlord Malakar",340,R.drawable.emberlordmalakar),
        Boss("Shadow Ignaroth",340, R.drawable.shadowignaroth)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, BossFragment())
            .commit()
    }
}