package com.example.androidunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val calculator = Calculator(Math())
        const val primeIndex = 2f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sum_squares.setOnClickListener {
            val num1 = et_num1.text.toString()
            val num2 = et_num2.text.toString()
            if (validateIntInputs(num1) && validateIntInputs(num2)) {
                tv_display_result.text = calculator.sumSquares(num1.toInt(), num2.toInt()).toString()
            }
        }

        btn_abs_diff.setOnClickListener {
            val num1 = et_num1.text.toString()
            val num2 = et_num2.text.toString()
            if (validateIntInputs(num1) && validateIntInputs(num2)) {
                tv_display_result.text = calculator.difference(num1.toInt(), num2.toInt()).toString()
            }
        }

        btn_factorial.setOnClickListener {
            val num1 = et_num_fact_prime.text.toString()
            if (validateIntInputs(num1)) {
                tv_display_result.text = calculator.factorial(num1.toInt()).toString()
            }
        }

        btn_check_prime.setOnClickListener {
            val num1 = et_num_fact_prime.text.toString()
            if (validateIntInputs(num1)) {
                tv_display_result.text = calculator.primeCheck(num1.toFloat(), primeIndex).toString()
            }
        }
    }

    private fun validateIntInputs(num1: String): Boolean {
        val number = num1.toIntOrNull()
        return if (number == null) {
            Toast.makeText(this, "Please enter an Integer", Toast.LENGTH_LONG).show()
            false
        } else true
    }
}
