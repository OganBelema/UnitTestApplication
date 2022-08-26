package com.oganbelema.unittestapplication

import org.junit.Assert.assertEquals
import org.junit.Test


class EngineTest {

    private val engine = Engine(15.0)

    @Test
    fun engineTurnsOn() {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        assertEquals(95.0, engine.temperature, 0.0)
    }

    @Test
    fun engineTurnsOff() {
        engine.turnOn()

        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)
        assertEquals(15.0, engine.temperature, 0.0)
    }
}