package com.oganbelema.unittestapplication.acceptanceTest

import com.oganbelema.unittestapplication.Car
import com.oganbelema.unittestapplication.Engine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CarFeatureText {

    private val engine = Engine(15.0)

    private val car = Car(6.0, engine)

    @Test
    fun carIsLoosingFuelWhenTurnedOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel, 0.0)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() {
        car.turnOn()

        assertEquals(95.0, car.engine.temperature, 0.0)
        assertTrue(car.engine.isTurnedOn)
    }
}