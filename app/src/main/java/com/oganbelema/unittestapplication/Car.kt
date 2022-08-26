package com.oganbelema.unittestapplication

class Car(var fuel: Double, val engine: Engine) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }
}