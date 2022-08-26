package com.oganbelema.unittestapplication

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class CarShouldTest {

    private val engine: Engine = mock()

    private val car = Car(5.0, engine)

    init {
        runBlockingTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25.0)

                delay(2000)
                emit(50.0)

                delay(2000)
                emit(95.0)
            })
        }
    }

    @get:Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carShouldLooseFuelWhenItTurnsOn() = runBlockingTest {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @Test
    fun carShouldTurnOnItsEngine() = runBlockingTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}