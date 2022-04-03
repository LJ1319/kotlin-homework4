package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var firstNumber: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClicked(clickedView: View) {
        if (clickedView is Button) {
            var viewText = resultTextView.text.toString()
            val buttonText = clickedView.text.toString()

            if (viewText == "0")
                viewText = ""

            resultTextView.text = viewText + buttonText
        }
    }

    fun operationClicked(clickedView: View) {
        // val operations = ["/", "*", "-", "+"]
        if (clickedView is Button) {
            firstNumber = resultTextView.text.toString().toDouble()
            resultTextView.text = "0"
            operation = clickedView.text.toString()
        }

    }

    fun dotClicked(clickedView: View) {

        if (clickedView is Button) {

            if (resultTextView.text.contains('.')) {
                val number = resultTextView.text.toString()
                resultTextView.text = number
            } else {
                val number = resultTextView.text.toString() + "."
                resultTextView.text = number
            }

        }
    }


    fun percClicked(clickedView: View) {
        val result = resultTextView.text.toString().toDouble() / 100
        resultTextView.text = result.toString()
    }

    fun sqrtClicked(clickedView: View) {
        val result = sqrt(resultTextView.text.toString().toDouble())
        resultTextView.text = result.toString()
    }

    fun plminClicked(clickedView: View) {
        val result = -(resultTextView.text.toString().toDouble())
        resultTextView.text = result.toString()
    }

    fun equalsClicked(clickedView: View) {
        val secondNumber = resultTextView.text.toString().toDouble()

        val finalResult = when (operation) {
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber

            else -> 0.0
        }
        resultTextView.text = finalResult.toString()
    }


    fun clearClicked(clickedView: View) {
        resultTextView.text = "0"
        operation = ""
    }
}