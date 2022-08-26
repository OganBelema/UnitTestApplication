package com.oganbelema.unittestapplication

class Engine(var temperature: Double,
             var isTurnedOn: Boolean = false){

    fun turnOn() {
        isTurnedOn = true
        temperature = 95.0
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15.0
    }
}