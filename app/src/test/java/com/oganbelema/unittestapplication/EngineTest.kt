package com.oganbelema.unittestapplication

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import kotlinx.coroutines.flow.toList
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
    }

    @Test
    fun riseTemperatureGraduallyWhenEngineTurnedOn() = runBlockingTest {
        val flow = engine.turnOn()

        val actual = flow.toList()

        assertEquals(listOf(25.0, 50.0, 95.0), actual)
    }

    @Test
    fun engineTurnsOff() = runBlockingTest {
        engine.turnOn()

        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)
        assertEquals(15.0, engine.temperature, 0.0)
    }
}