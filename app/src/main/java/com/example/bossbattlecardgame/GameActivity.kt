package com.example.bossbattlecardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class GameActivity : AppCompatActivity() {
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        viewModel = ViewModelProvider(this)[GameViewModel::class.java]

        viewModel.loadBoss(1)

        supportFragmentManager.beginTransaction()
            .replace(R.id.bossFragmentContainer, BossFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.playerFragmentContainer, PlayerFragment())
            .commit()
    }

}