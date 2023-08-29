package com.example.games.game

enum class GameStateProcess {

    INIT_PROCESS, PROCESSING, SUCCESSFUL, ERROR, ON_SUCCESS, ON_ERROR;

    companion object {

        fun getValue(str: String): GameStateProcess {

            val stateProcess = when (str) {
                "INIT_PROCESS" -> INIT_PROCESS
                "PROCESSING" -> PROCESSING
                "SUCCESSFUL" -> SUCCESSFUL
                "ERROR" -> ERROR
                "ON_SUCCESS" -> ON_SUCCESS
                "ON_ERROR" -> ON_ERROR
                else -> {
                    ERROR
                }
            }

            return stateProcess
        }
    }

}