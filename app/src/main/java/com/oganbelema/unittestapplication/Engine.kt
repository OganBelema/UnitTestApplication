package com.oganbelema.unittestapplication

import kotlinx.coroutines.delay

class Engine(var temperature: Double = 15.0,
             var isTurnedOn: Boolean = false){

    suspend fun turnOn() {
        isTurnedOn = true

        delay(6000)

        temperature = 95.0
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15.0
    }
}