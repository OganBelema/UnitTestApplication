package com.oganbelema.unittestapplication

class Engine(val cubicCentimeter: Int,
             val horsePower: Int,
             var temperature: Int,
             var isTurnedOn: Boolean){

    fun turnOn() {
        isTurnedOn = true
        temperature = 95
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15
    }
}