package com.example.androidunittesting

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class MathUnitTest {

    val math = mock(Math::class.java)
    val calculator = Calculator(math)

    @Test
    fun calcFactorial() {
        //setup
        val a = 5
        val expected = 120
        `when`(math.coolKidsDontUseForLoops(a)).thenReturn(expected)

        //execute
        val result = calculator.factorial(a)

        //check
        assertEquals(expected, result)
    }

    @Test
    fun calcSumSquares() {
        val a = 3
        val b = 5
        val expected = 34
        `when`(math.sumOfSquares(a,b)).thenReturn(expected)

        val result = calculator.sumSquares(a, b)

        assertEquals(expected, result)
    }

    @Test
    fun calcDiff() {
        val a = 100
        val b = -123
        val expected = -23
        `when`(math.absoluteDifference(a, b)).thenReturn(expected)

        val result = calculator.difference(a, b)

        assertEquals(expected, result)
    }
}