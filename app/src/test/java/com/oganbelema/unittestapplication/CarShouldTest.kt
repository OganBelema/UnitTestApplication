package com.oganbelema.unittestapplication

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class CarShouldTest {

    private val engine: Engine = mock()

    private val car = Car(5.0, engine)

    @Test
    fun carShouldLooseFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @Test
    fun carShouldTurnOnItsEngine() {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}