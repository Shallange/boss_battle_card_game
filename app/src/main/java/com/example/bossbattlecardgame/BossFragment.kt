package com.example.bossbattlecardgame

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class BossFragment : Fragment(R.layout.fragment_boss) {

    private lateinit var viewModel: GameViewModel
    private lateinit var  nameView: TextView
    private lateinit var  imageView: ImageView
    private lateinit var  hpFill: View
    private lateinit var  hpBar: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]

        nameView = view.findViewById(R.id.textBossName)
        imageView = view.findViewById(R.id.imgBoss)
        hpFill = view.findViewById(R.id.viewBossHpFill)
        hpBar = view.findViewById(R.id.viewBossHp)

        viewModel.currentBoss.observe(viewLifecycleOwner) { boss ->
            nameView.text = boss.name
            imageView.setImageResource(boss.imageResId)
            updateHpBar(boss)
        }
    }

    private fun updateHpBar(boss: Boss) {
        hpBar.post {
            val fullWidth = hpBar.width
            val progress = boss.currentHp.toFloat() / boss.maxHp
            val minWidthPx = (1 * resources.displayMetrics.density).toInt()

            hpFill.layoutParams.width = (fullWidth * progress).toInt().coerceAtLeast(minWidthPx)
            hpFill.requestLayout()
        }
    }
}
