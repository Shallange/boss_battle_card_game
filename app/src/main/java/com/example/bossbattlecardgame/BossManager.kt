package com.example.bossbattlecardgame

class BossManager {

    val bosses = mutableListOf<Boss>()
    init {
        initData()
    }

    private fun initData() {
        bosses.add(
            Boss(1,"Infernal Dread knight",340,R.drawable.infernaldreadknight)
        )
        bosses.add(
            Boss(2,"Emberlord Malakar",340,R.drawable.emberlordmalakar),
        )
        bosses.add(
            Boss(3,"Shadow Ignaroth",340, R.drawable.shadowignaroth)
        )
    }

    fun getBoss(id: Int): Boss? {
        return bosses.find { it.id == id }
    }

}
