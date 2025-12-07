package com.example.bossbattlecardgame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private val bossManager = BossManager()
    private val playerManager = PlayerManager()

    private val _currentBoss = MutableLiveData<Boss>()
    private val _bossDefeatedEvent = MutableLiveData<Boolean>()
    private val _playerDefeatedEvent = MutableLiveData<Boolean>()
    private val _player = MutableLiveData<Player>()
    private val _gameCompletedEvent = MutableLiveData<Boolean>()

    val currentBoss: LiveData<Boss> = _currentBoss
    val player: LiveData<Player> = _player

    val bossDefeatedEvent: LiveData<Boolean> = _bossDefeatedEvent
    val playerDefeatedEvent: LiveData<Boolean> = _playerDefeatedEvent
    val gameCompletedEvent: LiveData<Boolean> = _gameCompletedEvent


    private var currentBossIndex = 1
    private var isPlayerTurn = true

    fun startGame(build: PlayerBuild) {
        val player = playerManager.createPlayer(build)
        _player.value = player
        currentBossIndex = 1
        loadBoss(currentBossIndex)
    }

    fun resetBossDefeatedEvent() {
        _bossDefeatedEvent.value = false
    }

    fun resetPlayerDefeatedEvent() {
        _playerDefeatedEvent.value = false
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
            _gameCompletedEvent.value = true
        }
    }

    fun bossAttack(){
        val boss = _currentBoss.value ?: return
        val player = _player.value ?: return
        val shieldVal = playerManager.shieldValue(player.build)

        if(isPlayerTurn) return

        var damageTaken = boss.damage

        if (player.isShielding){
            damageTaken -= shieldVal
            player.isShielding = false
        }
        damageTaken = damageTaken.coerceAtLeast(0)

        player.currentHp = (player.currentHp - damageTaken).coerceAtLeast(0)

        if (player.currentHp == 0) {
            _playerDefeatedEvent.value = true
            return
        }
        _player.value = player
        isPlayerTurn = true
    }

    fun attackBoss(){
        val boss = _currentBoss.value ?: return // fetch boss live data
        val player = _player.value ?: return
        if (!isPlayerTurn) return

        val damage = playerManager.attackDamage(player.build)
        boss.currentHp = (boss.currentHp - damage).coerceAtLeast(0)// if result = less than 0 count as 0
        _currentBoss.value = boss

        if (boss.currentHp == 0){
            _bossDefeatedEvent.value = true
            return
        }
        isPlayerTurn = false
        bossAttack()
    }

    fun heal(){
        val player = _player.value ?: return
        if (!isPlayerTurn) return

        val heal = playerManager.healAmount(player.build)
        player.currentHp = (player.currentHp + heal).coerceAtMost(player.maxHp)
        _player.value = player
        isPlayerTurn = false
        bossAttack()
    }

    fun shield(){
        val player = _player.value ?: return
        if (!isPlayerTurn) return

        player.isShielding = true
        _player.value = player
        isPlayerTurn = false
        bossAttack()
    }
}