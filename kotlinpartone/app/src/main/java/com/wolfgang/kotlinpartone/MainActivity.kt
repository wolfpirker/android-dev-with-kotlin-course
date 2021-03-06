package com.wolfgang.kotlinpartone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a : Int = 10
        val b : Int = 5
        val c : Int = 3
        val d : Int = 9

        var result : Int = a + b
        Log.d("KotlinBeginners", "Result a + b : $result")

        result = a - b
        Log.d("KotlinBeginners", "Result a - b : $result")

        result = a/b
        Log.d("KotlinBeginners", "Result a/b : $result")

        result = a%b
        Log.d("KotlinBeginners", "Result a%b : $result")

        result = a%c
        Log.d("KotlinBeginners", "Result a%c : $result")

        result = a*b - d/c
        Log.d("KotlinBeginners", "Result a*b - d/c : $result")

        result = a*b + d/c
        Log.d("KotlinBeginners", "Result a*b + d/c : $result")

        result = (a*b + d)/c
        Log.d("KotlinBeginners", "Result (a*b + d)/c : $result")

        val myAge : Int = 30
        val yearsLater : Int = 10

        val myAgeIn2030 : Int = myAge + yearsLater

        Log.d("KotlinBeginners", "Result  : $myAgeIn2030")

        val myNumber1 : Float = 1.4f
        val myNumber2 : Float = 4.5f

        result = (myNumber1 + myNumber2).toInt()
        Log.d("KotlinBeginners", "Result for conversion : $result")

        val resultForFloatingPoints : Float = myNumber1 + myNumber2
        Log.d("KotlinBeginners", "resultForFloatingPoints : $resultForFloatingPoints")

        val isRaining : Boolean = true
        val isSunny : Boolean = false
        Log.d("KotlinBeginners", "if it is Raining : $isRaining and if it is sunny : $isSunny")

        val myFirstString : String = "My name is : "
        val mySecondString : String = "Wolfgang"
        val myThirdString : String = " and my age is 34"

        val resultsOfString1 : String = myFirstString + mySecondString + myThirdString
        val resultsOfString2 : String = "$myFirstString$mySecondString$myThirdString"
        Log.d("KotlinBeginners", "resultOfStrings : $resultsOfString1")
        Log.d("KotlinBeginners", "resultOfStrings : $resultsOfString2")

        val intArray : Array<Int> = arrayOf(1, 5, 8, 100)
        val stringArray : Array<String> = arrayOf("Wolfgang", "34", "android")
        val mixArray : Array<Any> = arrayOf(1, "Wolfgang", 1.5f, true, 'b')

        Log.d("KotlinBeginners", "intArray : ${intArray[0]}, ${stringArray[1]}, ${mixArray[3]}")

        Log.d("KotlinBeginners", "resultOfStringsTheSecond : ${(4 < 10) && (5<10)}")
    }
}