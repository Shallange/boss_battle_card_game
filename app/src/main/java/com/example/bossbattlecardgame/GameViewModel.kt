package com.example.bossbattlecardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val bossManager = BossManager()
    private val playerManager = PlayerManager()

    private val _currentBoss = MutableLiveData<Boss>()
    private val _bossDefeatedEvent = MutableLiveData<Boolean>()
    private val _player = MutableLiveData<Player>()


    val currentBoss: LiveData<Boss> = _currentBoss
    val bossDefeatedEvent: LiveData<Boolean> = _bossDefeatedEvent
    val player: LiveData<Player> = _player

    private var currentBossIndex = 1

    fun startGame(build: PlayerBuild) {
        val player = playerManager.createPlayer(build)
        _player.value = player
        currentBossIndex = 1
        loadBoss(currentBossIndex)
    }

    fun resetBossDefeatedEvent() {
        _bossDefeatedEvent.value = false
    }

    fun loadBoss(id: Int) {
        val boss = bossManager.getBoss(id) ?: return
        _currentBoss.value = boss
    }

    fun loadNextBoss() {
        currentBossIndex++
        val nextBoss = bossManager.getBoss(currentBossIndex)

        if (nextBoss != null) {
            _currentBoss.value = nextBoss
        } else {
            println("game won")
        }
    }

    fun attackBoss(){
        val boss = _currentBoss.value ?: return // fetch boss live data
        val player = _player.value ?: return
        val damage = playerManager.attackDamage(player.build)
        boss.currentHp = (boss.currentHp - damage).coerceAtLeast(0)// if result = less than 0 count as 0
        _currentBoss.value = boss

        if (boss.currentHp == 0){
            _bossDefeatedEvent.value = true
        }
    }

    fun heal(){
        val player = _player.value ?: return
        val heal = playerManager.healAmount(player.build)
        player.currentHp = (player.currentHp + heal).coerceAtMost(player.maxHp)
        _player.value = player
    }

    fun shield(){
        val player = _player.value ?: return
        player.isShielding = true
        _player.value = player
    }
}