package com.example.bossbattlecardgame

data class Boss(
    val id :Int,
    val name: String,
    var currentHp: Int,
    val maxHp: Int,
    val damage: Int,
    val imageResId: Int
)
