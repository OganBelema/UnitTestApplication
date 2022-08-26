package com.oganbelema.unittestapplication.acceptanceTest

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import com.oganbelema.unittestapplication.Car
import com.oganbelema.unittestapplication.Engine
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CarFeatureText {

    private val engine = Engine(15.0)

    private val car = Car(6.0, engine)

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenTurnedOn() = runBlockingTest {
        car.turnOn()

        assertEquals(5.5, car.fuel, 0.0)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperature() = runBlockingTest {
        car.turnOn()

        //because of the delay in turn on engine
        coroutinesTestRule.advanceTimeBy(6001)

        assertEquals(95.0, car.engine.temperature, 0.0)
        assertTrue(car.engine.isTurnedOn)
    }
}