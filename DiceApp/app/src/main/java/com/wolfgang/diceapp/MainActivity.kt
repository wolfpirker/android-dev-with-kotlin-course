package com.wolfgang.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

// Note: in classes: CamelCase writing by convention
class MainActivity : AppCompatActivity() {

    // Note: findViewById cannot be called here, before it is inizialized -> App crashs otherwise!
    lateinit var diceOneImg : ImageView
    lateinit var diceTwoImg : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceOneImg = findViewById(R.id.dice_one)
        diceTwoImg = findViewById(R.id.dice_two)

        val rollButton = findViewById<Button>(R.id.btn_roll_dice)

        rollButton.setOnClickListener {
            rollDice(diceOneImg)
            rollDice(diceTwoImg)
        }
    }

    // Note convention: first word lower case; 2nd 1st letter uppercase
    fun rollDice(imgView: ImageView){
        val randomNumber = (1..6).random()

        val image = when (randomNumber){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice_empty
        }
        imgView.setImageResource(image)
    }
}