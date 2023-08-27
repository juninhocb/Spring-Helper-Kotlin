package com.example.games.game

enum class GameResult {

    DRAW, WIN, LOSE;

    companion object {
        fun getGameResult(str: String): GameResult {
            return when (str) {
                "DRAW" -> DRAW
                "WIN" -> WIN
                "LOSE" -> LOSE
                else -> DRAW
            }
        }
    }
}