package com.example.bossbattlecardgame

data class Boss(
    val id :Int,
    val name: String,
    var currentHp: Int,
    val maxHp: Int,
    val imageResId: Int
)
