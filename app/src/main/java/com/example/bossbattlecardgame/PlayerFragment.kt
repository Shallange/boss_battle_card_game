package com.example.bossbattlecardgame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PlayerFragment : Fragment(R.layout.fragment_player) {
    private lateinit var viewModel: GameViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]

    }
}
