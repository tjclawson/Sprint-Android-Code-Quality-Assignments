package com.example.androidunittesting

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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
        private const val FACTORIAL_PRIME = "5"
        private const val NUM_ONE = "5"
        private const val NUM_TWO = "3"
        private const val SUM_RESULT = "34"
        private const val DIFF_RESULT = "2"
        private const val FACTORIAL_RESULT = "120"
        private const val PRIME_RESULT = "true"
    }

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_calcFactorial() {
        //setup
        onView(withId(R.id.et_num_fact_prime))
            .perform(typeText(FACTORIAL_PRIME), closeSoftKeyboard())

        //execute
        onView(withId(R.id.btn_factorial)).perform(click())

        //check
        onView(withId(R.id.tv_display_result)).check(matches(withText(FACTORIAL_RESULT)))
    }

    @Test
    fun b_calcSumOfSqaures() {
        //setup
        onView(withId(R.id.et_num1)).perform(typeText(NUM_ONE))
        onView(withId(R.id.et_num2)).perform(typeText(NUM_TWO))

        //execute
        onView(withId(R.id.btn_sum_squares)).perform(click())

        //check
        onView(withId(R.id.tv_display_result)).check(matches(withText(SUM_RESULT)))
    }

    @Test
    fun c_calcAbsDiff() {
        //setup
        onView(withId(R.id.et_num1)).perform(typeText(NUM_ONE))
        onView(withId(R.id.et_num2)).perform(typeText(NUM_TWO), closeSoftKeyboard())

        //execute
        onView(withId(R.id.btn_abs_diff)).perform(click())

        //check
        onView(withId(R.id.tv_display_result)).check(matches(withText(DIFF_RESULT)))
    }

    @Test
    fun d_checkPrime() {
        //setup
        onView(withId(R.id.et_num_fact_prime))
            .perform(typeText(FACTORIAL_PRIME), closeSoftKeyboard())

        //execute
        onView(withId(R.id.btn_check_prime)).perform(click())

        //check
        onView(withId(R.id.tv_display_result)).check(matches(withText(PRIME_RESULT)))
    }
}