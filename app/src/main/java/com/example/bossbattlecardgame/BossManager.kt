package com.example.bossbattlecardgame

class BossManager {

    val bosses = mutableListOf<Boss>()
    init {
        initData()
    }

    private fun initData() {
        bosses.add(
            Boss("Infernal Dread knight",340,R.drawable.infernaldreadknight)
        )
        bosses.add(
            Boss("Emberlord Malakar",340,R.drawable.emberlordmalakar),
        )
        bosses.add(
            Boss("Shadow Ignaroth",340, R.drawable.shadowignaroth)
        )
    }
}
