package com.example.bossbattlecardgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bossbattlecardgame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[GameViewModel::class.java]

        viewModel.loadBoss(1)

        supportFragmentManager.beginTransaction()
            .replace(binding.bossFragmentContainer.id, BossFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(binding.playerFragmentContainer.id, PlayerFragment())
            .commit()
    }

}