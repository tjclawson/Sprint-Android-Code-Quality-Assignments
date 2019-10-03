package com.example.androidunittesting

import kotlin.math.absoluteValue

class Math {

    fun sumOfSquares(a: Int, b: Int): Int {
        return (a * a) + (b * b)
    }

    fun absoluteDifference(a: Int, b: Int): Int {
        return (a.absoluteValue - b.absoluteValue)
    }

    fun coolKidsDontUseForLoops(a: Int): Int {
        return if (a == 1) a else a*coolKidsDontUseForLoops(a - 1)
    }

    fun checkPrime(a: Int): Boolean {
        var count = 0
        for (i in 0 until a) {
            if (a / (a - i) == a % (a - i)) count++
        }
        return if (count == 1) true else false
    }

    fun checkPrimeRecurse(a: Float, i: Float): Boolean {
        if (a != i) {
            return if (a % i == 0f) false else checkPrimeRecurse(a, i + 1)
        } else return true
    }
}