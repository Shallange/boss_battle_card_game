package com.example.bossbattlecardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val bossManager = BossManager()
    private val _currentBoss = MutableLiveData<Boss>()

    val currentBoss: LiveData<Boss> = _currentBoss

    fun loadBoss(id: Int) {
        val boss = bossManager.getBoss(id) ?: return
        _currentBoss.value = boss
    }
}