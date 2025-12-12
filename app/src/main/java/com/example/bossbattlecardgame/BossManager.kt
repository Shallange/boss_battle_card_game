package com.example.bossbattlecardgame

class BossManager {

    val bosses = mutableListOf<Boss>()
    init {
        initData()
    }

    private fun initData() {
        bosses.add(
            Boss(1,"Infernal knight",420,420,14,R.drawable.infernaldreadknight)
        )
        bosses.add(
            Boss(2,"Emberlord Malakar",650,650,22,R.drawable.emberlordmalakar),
        )
        bosses.add(
            Boss(3,"Shadow Ignaroth",900, 900,30,R.drawable.shadowignaroth)
        )
    }

    fun getBoss(id: Int): Boss? {
        return bosses.find { it.id == id }
    }
}
