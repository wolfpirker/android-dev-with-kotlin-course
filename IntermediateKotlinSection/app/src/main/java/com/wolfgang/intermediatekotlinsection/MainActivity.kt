package com.wolfgang.intermediatekotlinsection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try{
            20/0
        }
        catch (exception: Exception){
            exception.printStackTrace()
        }

    }
}