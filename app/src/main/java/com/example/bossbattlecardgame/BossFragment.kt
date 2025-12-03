package com.example.bossbattlecardgame

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BossFragment : Fragment(R.layout.fragment_boss) {

    private lateinit var viewModel: GameViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]

        val nameView = view.findViewById<TextView>(R.id.textBossName)
        val imageView = view.findViewById<ImageView>(R.id.imgBoss)

        viewModel.currentBoss.observe(viewLifecycleOwner) { boss ->
            nameView.text = boss.name
            imageView.setImageResource(boss.imageResId)
        }
    }

}
