package com.oganbelema.unittestapplication

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(var temperature: Double = 15.0,
             var isTurnedOn: Boolean = false){

    suspend fun turnOn(): Flow<Double> {
        isTurnedOn = true

        return flow {
            delay(2000)
            temperature = 25.0
            emit(temperature)

            delay(2000)
            temperature = 50.0
            emit(temperature)

            delay(2000)
            temperature = 95.0
            emit(temperature)
        }
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15.0
    }
}