package com.example.bossbattlecardgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PlayerFragment : Fragment(R.layout.fragment_player) {
    private lateinit var viewModel: GameViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]

        val attackBtn = view.findViewById<Button>(R.id.playerAttack)
        val shieldBtn = view.findViewById<Button>(R.id.playerShield)
        val healBtn = view.findViewById<Button>(R.id.playerHeal)

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
}
