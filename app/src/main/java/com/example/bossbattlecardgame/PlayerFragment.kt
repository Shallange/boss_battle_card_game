package com.example.bossbattlecardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PlayerFragment : Fragment(R.layout.fragment_player) {
    private lateinit var viewModel: GameViewModel

    private lateinit var  buildNameView: TextView
    private lateinit var  hpFill: View
    private lateinit var  hpBar: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
        buildNameView = view.findViewById(R.id.textPlayerBuild)
        hpFill = view.findViewById(R.id.viewPlayerHpFill)
        hpBar = view.findViewById(R.id.viewPlayerHp)

        val attackBtn = view.findViewById<Button>(R.id.playerAttack)
        val shieldBtn = view.findViewById<Button>(R.id.playerShield)
        val healBtn = view.findViewById<Button>(R.id.playerHeal)

        viewModel.player.observe(viewLifecycleOwner) { player ->
            buildNameView.text = player.build.name
            updateHpBar(player)
        }

        attackBtn.setOnClickListener {
            viewModel.attackBoss()
        }

        shieldBtn.setOnClickListener {
            viewModel.shield()
        }

        healBtn.setOnClickListener {
            viewModel.heal()
        }
    }

    private fun updateHpBar(player: Player) {
        hpBar.post {
            val fullWidth = hpBar.width
            val progress = player.currentHp.toFloat() / player.maxHp
            hpFill.layoutParams.width = (fullWidth * progress).toInt()
            hpFill.requestLayout()
        }
    }
}
