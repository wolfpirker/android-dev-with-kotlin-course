package com.wolfgang.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wolfgang.dictionaryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // API, Key (Learners)
    // 2c915c85-1a95-4247-b97a-21437a92a82d

    // JSON Request
    // https://www.dictionaryapi.com/api/v3/references/learners/json/
    // apple?key=your-api-key

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}