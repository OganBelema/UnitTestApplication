package com.oganbelema.unittestapplication

class Engine(var temperature: Double = 15.0,
             var isTurnedOn: Boolean = false){

    fun turnOn() {
        isTurnedOn = true

        Thread.sleep(6000)

        temperature = 95.0
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15.0
    }
}