package com.example.bossbattlecardgame

import android.content.Intent
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
        viewModel.playerDefeatedEvent.observe(this) { defeated ->
            if (defeated) {
                showPlayerDefeatedOverlay()
            }
        }
        viewModel.gameCompletedEvent.observe(this) { done ->
            if (done) {
                showGameCompletedOverlay()
            }
        }

    }

    private fun showBossDefeatedOverlay() {
        binding.overlayBossDefeated.visibility = View.VISIBLE
        binding.textBossDefeated.visibility = View.VISIBLE
        binding.btnNextBoss.visibility = View.VISIBLE

        binding.btnNextBoss.setOnClickListener {
            hideBossOverlay()
            viewModel.resetBossDefeatedEvent()
            viewModel.loadNextBoss()
        }
    }

    private fun hideBossOverlay() {
        binding.overlayBossDefeated.visibility = View.GONE
        binding.textBossDefeated.visibility = View.GONE
        binding.btnNextBoss.visibility = View.GONE
    }

    private fun showPlayerDefeatedOverlay() {
        binding.overlayPlayerDefeated.visibility = View.VISIBLE
        binding.textPlayerDefeated.visibility = View.VISIBLE
        binding.btnTryAgain.visibility = View.VISIBLE

        binding.btnTryAgain.setOnClickListener {
            hidePlayerOverlay()
            viewModel.resetPlayerDefeatedEvent()
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }
    }

    private fun hidePlayerOverlay() {
        binding.overlayPlayerDefeated.visibility = View.GONE
        binding.textPlayerDefeated.visibility = View.GONE
        binding.btnTryAgain.visibility = View.GONE
    }

    private fun showGameCompletedOverlay() {
        binding.overlayGameWon.visibility = View.VISIBLE
        binding.textGameWon.visibility = View.VISIBLE
        binding.btnWonGame.visibility = View.VISIBLE

        binding.btnWonGame.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }
    }

}