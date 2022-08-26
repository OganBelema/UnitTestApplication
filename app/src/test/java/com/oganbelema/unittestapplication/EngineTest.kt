package com.oganbelema.unittestapplication

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test


class EngineTest {

    private val engine = Engine(15.0)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun engineTurnsOn() = runBlockingTest {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)
        assertEquals(95.0, engine.temperature, 0.0)
    }

    @Test
    fun engineTurnsOff() = runBlockingTest {
        engine.turnOn()

        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)
        assertEquals(15.0, engine.temperature, 0.0)
    }
}