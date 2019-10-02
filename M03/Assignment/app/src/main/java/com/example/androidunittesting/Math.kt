package com.example.androidunittesting

import kotlin.math.absoluteValue

class Math {

    fun sumOfSquares(a: Int, b: Int): Int {
        return (a * a) * (b * b)
    }

    fun absoluteDifference(a: Int, b: Int): Int {
        return (a.absoluteValue - b.absoluteValue)
    }

    fun coolKidsDontUseForLoops(a: Int): Int {
        return if (a == 1) a else a*coolKidsDontUseForLoops(a - 1)
    }
}