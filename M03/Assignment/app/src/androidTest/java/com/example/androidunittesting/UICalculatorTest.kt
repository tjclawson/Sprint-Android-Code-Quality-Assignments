package com.example.androidunittesting

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UICalculatorTest {

    companion object {
        private const val FACTORIAL = "5"
        //private const val
    }

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_calcFactorial() {
        //setup

        //execute

        //check
    }

    @Test
    fun b_calcSumOfSqaures() {
        //setup

        //execute

        //check
    }

    @Test
    fun c_calcAbsDiff() {
        //setup

        //execute

        //check
    }

    @Test
    fun d_checkPrime() {
        //setup

        //execute

        //check
    }
}