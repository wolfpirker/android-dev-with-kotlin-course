package com.wolfgang.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.wolfgang.guessnumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number : Int = 5
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) // not like this!

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        printTheQuestion()
    }

    private fun printTheQuestion(){
        if (!binding.txtvQuestion.isVisible){
            binding.txtvQuestion.visibility = View.VISIBLE
        }
        binding.txtvQuestion.text = String.format(resources.getString(R.string.str_question), number)

    }

    private fun guessTheNumber(myNumber : Int){
        number = myNumber
        printTheQuestion()
    }

    fun clickDownwardArrow(view: View) {
        if (number == 5){
            guessTheNumber(3)
        }else if (number == 3){
            guessTheNumber(2)
        }else if(number == 2){
            guessTheNumber(1)
        }else if (number == 8){
            guessTheNumber(7)
        }else if (number == 7){
            guessTheNumber(6)
        }
    }

    fun clickSuccess(view: View) {
        /*binding.txtvQuestion.isVisible = false
        binding.txtvResult.isVisible = true
         */
        // better like this:

        binding.txtvQuestion.visibility = View.INVISIBLE
        binding.txtvResult.visibility = View.VISIBLE
        binding.txtvResult.text = String.format(resources.getString(R.string.str_success), number)

    }

    fun clickUpwardArrow(view: View) {
        if (number == 3){
            guessTheNumber(4)
        }else if (number == 5){
            guessTheNumber(8)
        }else if (number == 8){
            guessTheNumber(9)
        }else if (number == 9){
            guessTheNumber(10)
        }
    }

    fun clickResetButton(view: View) {
        binding.txtvResult.visibility = View.INVISIBLE
        number = 5
        printTheQuestion()
    }
}