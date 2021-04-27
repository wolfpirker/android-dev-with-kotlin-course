package com.wolfgang.kotlinforbeginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number : Int = 19

        var result : String = ""

        if (number % 2 == 0){
            result = "even"
        } else {
            result = "odd"
        }

        Log.d("KotlinForBeginners", result)

        val numA : Float = 52.5f
        val numB : Float = 25.2f

        var maxNum = if (numA > numB){
            numA
        }
        else {
            numB
        }

        Log.d("KotlinForBeginners", "max num is: $maxNum")

        val age : Int = 34

        val person = if (age < 12){
            "child"
        } else if (age in 13..20){
            "Teen"
        } else if (age > 20 && age <= 50){
            "Adult"
        } else {
            "of Old Age"
        }
        Log.d("KotlinForBeginners", "the person is $person" )
    }
}