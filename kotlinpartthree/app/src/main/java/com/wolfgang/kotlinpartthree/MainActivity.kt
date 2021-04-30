package com.wolfgang.kotlinpartthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dayOfWeek: Int = 5

        val day = when (dayOfWeek) {
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            6 -> "Saturday"
            7 -> "Sunday"
            else -> "Invalid Day"
        }

        Log.d("KotlinForBeginnersPat3", "day of week is : $day")


        val toDo = when (dayOfWeek) {
            in 1..5 -> "Go to School"
            in 6..7 -> "Have fun, it is weekend"
            else -> "Invalid day"
        }
        Log.d("KotlinForBeginnersPat3", "What to do today : $toDo")

        val myNumber = 156

        val numberOfDigits = when (myNumber) {
            in 1..9 -> "One Digit Number"
            in 10..99 -> "Two Digits Number"
            in 100..999 -> "Three Digits Number"
            else -> "Four or More Than Four Digits"
        }

        Log.d("KotlinForBeginnersPat3", "Number of Digits are : $numberOfDigits")

        //val numberTypeGuess: Any = 19.000000
        val numberTypeGuess: Any = 19.00f

        val numberDataType = when (numberTypeGuess) {

            is Int -> "Int"
            is Float -> "Float"
            is String -> "String"
            is Boolean -> "Boolean"
            is Array<*> -> "Array"
            else -> "Invalid Data Type or Haven't been studied yet"
        }
        Log.d("KotlinForBeginnersPat3", "Number Type is : $numberDataType")

        var myNumberIncreasing: Int = 1

        while (myNumberIncreasing < 10) {
            myNumberIncreasing += 1
            Log.d("KotlinForBeginnersPat3", "While, My Increased Number is : $myNumberIncreasing")
        }

        do {
            myNumberIncreasing += 1
            Log.d(
                    "KotlinForBeginnersPat3",
                    "Do-while, My Increased Number is : $myNumberIncreasing"
            )
        } while (myNumberIncreasing < 10)

        for (i in 1..5) {
            Log.d("KotlinForBeginnersPat3", "i in Range is : $i")
        }

        for (i in 5 downTo 1) {
            Log.d("KotlinForBeginnersPat3", "i in Reversed Range is : $i")
        }

        for (i in 5..20 step 2) {
            Log.d("KotlinForBeginnersPat3", "i in Advance 2 : $i")
        }

        val myArray: Array<String> =
                arrayOf("android", "Q", "Kotlin", "practice as much as you can", "developer")

        for (element in myArray) {
            Log.d("KotlinForBeginnersPat3", "elements of Array : $element ")
        }

        for (index in myArray.indices) {
            Log.d("KotlinForBeginnersPat3", "myArray[$index] = ${myArray[index]} ")
        }

        for ((index, element) in myArray.withIndex()) {
            Log.d("KotlinForBeginnersPat3", "myArray[$index] = $element")
        }

        // val myString = "Wolfgang" // Kotlin interferes the type like that automatically
        val myString: String? = null // usually better explicit types
        // val myString: String? = "Wolfgang"

        // Note: with the safe call operator no exception with value NULL!
        Log.d("KotlinForBeginnersPat3", "null safe operator : ${myString?.length}")

        myString?.let {
            Log.d("KotlinForBeginnersPat3", "let operator : ${it.length}")
        }

        val length = if (myString != null) {
            myString.length
        } else {
            -1
        }

        // Note: this does about the same... with the elvis operator, shorter:
        val length2 = myString?.length ?: -1

        Log.d("KotlinForBeginnersPat3", "elvis operator : $length")
        Log.d("KotlinForBeginnersPat3", "elvis operator : $length2")

        // with NULL value, exception: KotlinNullPointerException!
        // we don't want that; so we use the operators before;
        // avoid double bang operator!
        val length3 = myString!!.length
        Log.d("KotlinForBeginnersPat3", "double bang operator : $length3")
    }
}