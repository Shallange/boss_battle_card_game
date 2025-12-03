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
    fun attackBoss(){
        val boss = _currentBoss.value ?: return // fetch boss live data
        boss.currentHp = (boss.currentHp - 20).coerceAtLeast(0)// if result = less than 0 count as 0
        _currentBoss.value = boss
    }
    fun heal(){

    }
    fun shield(){

    }

}