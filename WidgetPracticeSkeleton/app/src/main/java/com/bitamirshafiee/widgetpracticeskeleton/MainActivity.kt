package com.bitamirshafiee.widgetpracticeskeleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import com.bitamirshafiee.widgetpracticeskeleton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ageTextView.text = String.format(resources.getString(R.string.str_age), 0)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // value of SeekBar changed
                binding.ageTextView.text =
                    String.format(resources.getString(R.string.str_age), progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        ArrayAdapter.createFromResource(
            this,
            R.array.list_of_units,
            android.R.layout.simple_list_item_1
        ).also { arrayAdapter ->
            binding.spinner.adapter = arrayAdapter
        }
    }
}