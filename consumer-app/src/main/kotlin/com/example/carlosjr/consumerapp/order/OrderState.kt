package com.example.carlosjr.consumerapp.order

enum class OrderState {

    INIT_PROCESS, PROCESSING, PROCESSED;

    companion object  {
        fun getState(str: String) : OrderState {

            val stateProcess = when (str){
                "INIT_PROCESS" -> INIT_PROCESS
                "PROCESSING" -> PROCESSING
                "PROCESSED" -> PROCESSED
                else -> {INIT_PROCESS}
            }

            return stateProcess
        }
    }

}