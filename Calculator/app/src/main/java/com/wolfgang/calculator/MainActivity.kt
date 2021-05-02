package com.wolfgang.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.function.ToDoubleFunction

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    var termPrev : Double = 0.0
    var operator : Char = '+'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.number_edit_text)
    }

    fun operationFunction(view: View) {
        // Note: much of that was accomplished without the proposed
        // solution in the Kotlin Udemy course

        val btn = view as Button
        var value : String = ""

        editText.text?.let{
            value = it.toString()
        }

        when (view.id){
            R.id.button_division -> {
                operator = '/'
                calcOperatorClicked(value)

            }
            R.id.button_minus -> {
                operator = '-'
                calcOperatorClicked(value)
            }
            R.id.button_plus -> {
                operator = '+'
                calcOperatorClicked(value)
            }
            R.id.button_equal-> {
                equalsClicked(value)
            }
            R.id.button_c -> {
                editText.setText("")
            }
            else -> {
                numberClicked(btn.text.toString())
            }
        }
    }

    private fun equalsClicked(value: String){
        var result : Double = 0.0

        if (operator == '/'){
            if (value.toDouble() != 0.0){
                result = termPrev/value.toDouble()
                editText.setText(result.toString())
            }
            else{
                editText.setText("NaN")
            }
        }
        else if (operator == '+'){
            result = termPrev+value.toDouble()
            editText.setText(result.toString())
        }
        else if (operator == '-'){
            result = termPrev-value.toDouble()
            editText.setText(result.toString())
        }
    }

    private fun numberClicked(numberClicked : String){
        val number = editText.text.toString() + numberClicked.toString()
        editText.setText(number)
    }

    private fun calcOperatorClicked(value: String){
        // Note: weakness: works only with one term - so equal sign has to pressed
        // after using only one calculation (+,/,-) operator
        termPrev = value.toDouble()
        editText.setText("")
    }
}