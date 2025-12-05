package com.example.bossbattlecardgame

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
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

        val prefs: SharedPreferences? = getSharedPreferences("game_prefs", MODE_PRIVATE)
        //defaults to Balanced build
        val buildName = prefs?.getString("player_build", PlayerBuild.BALANCED.name)
        val build = PlayerBuild.valueOf(buildName!!)

        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        viewModel.startGame(build)

        supportFragmentManager.beginTransaction()
            .replace(binding.bossFragmentContainer.id, BossFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(binding.playerFragmentContainer.id, PlayerFragment())
            .commit()

        viewModel.bossDefeatedEvent.observe(this) { defeated ->
            if (defeated) {
                showBossDefeatedOverlay()
            }
        }
    }

    private fun showBossDefeatedOverlay() {
        binding.overlayBossDefeated.visibility = View.VISIBLE
        binding.textBossDefeated.visibility = View.VISIBLE
        binding.btnNextBoss.visibility = View.VISIBLE

        binding.btnNextBoss.setOnClickListener {
            hideOverlay()
            viewModel.resetBossDefeatedEvent()
            viewModel.loadNextBoss()
        }
    }

    private fun hideOverlay() {
        binding.overlayBossDefeated.visibility = View.GONE
        binding.textBossDefeated.visibility = View.GONE
        binding.btnNextBoss.visibility = View.GONE
    }

}