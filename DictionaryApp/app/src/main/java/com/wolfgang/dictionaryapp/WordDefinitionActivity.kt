package com.wolfgang.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wolfgang.dictionaryapp.databinding.ActivityDefinitionBinding

class WordDefinitionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDefinitionBinding
    private val KEY = "WORD_DEFINITION"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDefinitionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_definition)
        val view = binding.root
        setContentView(view)

        binding.txtvDefinition.text = intent.getStringExtra(KEY)

        binding.imgBack.setOnClickListener { finish() }
    }

    fun clickBackwardArrow(view: View) {}
}