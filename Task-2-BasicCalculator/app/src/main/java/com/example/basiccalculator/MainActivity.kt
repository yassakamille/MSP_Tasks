package com.example.basiccalculator

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.basiccalculator.R
import java.lang.Exception
//import kotlin.Throw
import java.lang.IllegalArgumentException
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.res)
        val refids = intArrayOf(
            R.id.btn_plus, R.id.btn_minus, R.id.btn_mult, R.id.btn_divide,
            R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9, R.id.btn_c, R.id.btn_res
        )
        val num_btns = arrayOfNulls<TextView>(refids.size)
        for (i in refids.indices) {
            num_btns[i] = findViewById(refids[i])
        }
        for (button in num_btns) {
            button!!.setOnClickListener {
                val operate = button.tag.toString()
                if (operate != "=" && operate != "C") {
                    appendToResult(operate)
                } else if (operate == "=") {
                    calculateResult()
                } else if (operate == "C") {
                    clearResult()
                }
            }
        }
    }

    private fun appendToResult(value: String) {
        result!!.append(value)
    }

    private fun calculateResult() {
        val expression = result!!.text.toString()
        try {
            val resultValue = evaluateExpression(expression)
            result!!.text = resultValue.toString()
        } catch (e: Exception) {
            result!!.text = "Error"
        }
    }

    private fun clearResult() {
        result!!.text = ""
    }

//    @Throws(Exception::class)
    private fun evaluateExpression(expression: String): Double {
        val tokens = expression.split("(?<=[-+x/])|(?=[-+x/])".toRegex()).toTypedArray()
        require(tokens.size == 3) { "Invalid expression: $expression" }
        val operand1 = tokens[0].toDouble()
        val operand2 = tokens[2].toDouble()
        val operator = tokens[1]
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "x" -> operand1 * operand2
            "/" -> if (operand2 != 0.0) {
                operand1 / operand2
            } else {
                throw ArithmeticException("Division by zero")
            }
            else -> throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
}
