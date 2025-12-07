package com.example.bossbattlecardgame

class PlayerManager {

    fun createPlayer(build: PlayerBuild): Player {
        return when (build) {
            PlayerBuild.DAMAGE ->
                Player(maxHp = 200, currentHp = 200, build = build)

            PlayerBuild.DEFENSIVE ->
                Player(maxHp = 300, currentHp = 300, build = build)

            PlayerBuild.BALANCED ->
                Player(maxHp = 250, currentHp = 250, build = build)

            PlayerBuild.HEALER ->
                Player(maxHp = 220, currentHp = 220, build = build)
        }
    }

    fun attackDamage(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 45
            PlayerBuild.DEFENSIVE -> 15
            PlayerBuild.BALANCED -> 25
            PlayerBuild.HEALER -> 10
        }
    }

    fun healAmount(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 5
            PlayerBuild.DEFENSIVE -> 10
            PlayerBuild.BALANCED -> 15
            PlayerBuild.HEALER -> 40
        }
    }

    fun shieldValue(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 10
            PlayerBuild.DEFENSIVE -> 40
            PlayerBuild.BALANCED -> 20
            PlayerBuild.HEALER -> 10
        }
    }
}
