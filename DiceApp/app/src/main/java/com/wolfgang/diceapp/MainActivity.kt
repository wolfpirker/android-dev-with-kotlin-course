package com.wolfgang.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Note: in classes: CamelCase writing by convention
class MainActivity : AppCompatActivity() {

    // Note: findViewById cannot be called here, before it is inizialized -> App crashs otherwise!
    lateinit var randomNumberTxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomNumberTxt = findViewById<TextView>(R.id.text_view_random_number)
        val rollButton = findViewById<Button>(R.id.btn_roll_dice)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    // Note convention: first word lower case; 2nd 1st letter uppercase
    fun rollDice(){
        val randomNumber = (1..6).random()
        randomNumberTxt.text = randomNumber.toString()
    }
}