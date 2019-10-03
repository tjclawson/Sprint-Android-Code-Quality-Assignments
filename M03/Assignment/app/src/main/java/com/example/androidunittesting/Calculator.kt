package com.example.androidunittesting

class Calculator (private val math: Math) {

    fun factorial(a: Int): Int {
        return math.coolKidsDontUseForLoops(a)
    }

    fun difference(a: Int, b: Int): Int {
        return math.absoluteDifference(a, b)
    }

    fun sumSquares(a: Int, b: Int): Int {
        return math.sumOfSquares(a, b)
    }

    fun primeCheck(a: Float, i: Float): Boolean {
        return math.checkPrimeRecurse(a, i)
    }
}