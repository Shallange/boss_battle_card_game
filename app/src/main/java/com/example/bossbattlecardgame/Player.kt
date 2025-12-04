package com.example.bossbattlecardgame
data class Player(
    var build: PlayerBuild,
    val maxHp: Int,
    var currentHp: Int,
    var isShielding: Boolean = false
)

enum class PlayerBuild {
    DAMAGE,
    DEFENSIVE,
    BALANCED,
    HEALER
}
