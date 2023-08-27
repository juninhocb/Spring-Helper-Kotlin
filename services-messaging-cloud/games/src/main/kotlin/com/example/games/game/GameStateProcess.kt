package com.example.games.game

enum class GameStateProcess {

    INIT_PROCESS, PROCESSING, SUCCESSFUL, ERROR, ON_SUCCESS, ON_ERROR;

    fun getValue(code: Int) : GameStateProcess? {

        val stateProcess = when(code) {
            1 -> INIT_PROCESS
            2 -> PROCESSING
            3 -> SUCCESSFUL
            4 -> ERROR
            5 -> ON_SUCCESS
            6 -> ON_ERROR
            else -> {null}
        }

        return stateProcess
    }

}