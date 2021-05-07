package com.wolfgang.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wolfgang.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.buttonCalculate.setOnClickListener {

            if (binding.weightEditText.text.isNotEmpty() && binding.lengthEditText.text.isNotEmpty()) {
                calculateBMI()
            } else {
                Toast.makeText(this, "enter the needed field", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun calculateBMI() {
        var weight : Float = 0f
        var length : Float = 0f

        // Note: here not required to check string with let
        binding.weightEditText.text.toString()?.let {
            // Log.d("Weight Number", "weight is : $it")
            weight = it.toFloat()
        }
        binding.lengthEditText.text.toString()?.let {
            // Log.d("length Number", "length is : $it")
            length = it.toFloat()
        }
        val bmi = weight / (length*length)

        binding.textviewBmiValue.text = bmi.toString()

        if (bmi < 18.5) {
            binding.imageBody.setImageResource(R.drawable.ic_body_underweight)
        } else if (bmi >= 18.5 && bmi < 24.9) {
            binding.imageBody.setImageResource(R.drawable.ic_body_healthy)
        } else if (bmi >= 24.9 && bmi < 29.9) {
            binding.imageBody.setImageResource(R.drawable.ic_body_overweight)
        } else if (bmi >= 29.9) {
            binding.imageBody.setImageResource(R.drawable.ic_body_obesity)
        }

    }
}