package com.example.bossbattlecardgame

class PlayerManager {

    fun createPlayer(build: PlayerBuild): Player {
        return when (build) {
            PlayerBuild.DAMAGE ->
                Player(maxHp = 220, currentHp = 220, build = build)

            PlayerBuild.DEFENSIVE ->
                Player(maxHp = 340, currentHp = 340, build = build)

            PlayerBuild.BALANCED ->
                Player(maxHp = 280, currentHp = 280, build = build)

            PlayerBuild.HEALER ->
                Player(maxHp = 240, currentHp = 240, build = build)
        }
    }

    fun attackDamage(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 50
            PlayerBuild.DEFENSIVE -> 20
            PlayerBuild.BALANCED -> 30
            PlayerBuild.HEALER -> 15
        }
    }

    fun healAmount(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 10
            PlayerBuild.DEFENSIVE -> 20
            PlayerBuild.BALANCED -> 25
            PlayerBuild.HEALER -> 45
        }
    }

    fun shieldValue(build: PlayerBuild): Int {
        return when (build) {
            PlayerBuild.DAMAGE -> 15
            PlayerBuild.DEFENSIVE -> 45
            PlayerBuild.BALANCED -> 30
            PlayerBuild.HEALER -> 20
        }
    }
}
