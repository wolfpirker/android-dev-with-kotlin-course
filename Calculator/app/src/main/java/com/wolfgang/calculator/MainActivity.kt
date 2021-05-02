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
        var result : Double = 0.0

        editText.text?.let{
            value = it.toString()
        }

        when (view.id){
            R.id.button_division -> {
                termPrev = value.toDouble()
                operator = '/'
                editText.setText("")
            }
            R.id.button_minus -> {
                termPrev = value.toDouble()
                operator = '-'
                editText.setText("")
            }
            R.id.button_plus -> {
                termPrev = value.toDouble()
                operator = '+'
                editText.setText("")
            }
            R.id.button_equal-> {
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
            R.id.button_c -> {
                editText.setText("")
            }
            else -> {
                editText.setText(editText.text.toString() + btn.text)
            }

        }

        /* lecture #80: so much typing...
        when (view.id) {
            R.id.button_one -> {
                val number = editText.text.toString() + "1"
                editText.setText(number)
            }
        }
        */

    }
}