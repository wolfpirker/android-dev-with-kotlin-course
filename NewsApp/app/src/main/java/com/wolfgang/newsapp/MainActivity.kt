package com.wolfgang.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.wolfgang.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        super.onCreate(savedInstanceState)
        setContentView(view)

        val queue = Volley.newRequestQueue(this)
        binding.buttonSearch.setOnClickListener {
            val word = binding.textSearch.text
            val url = getUrl()
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {
                    response ->
                    response
                    /*
                    try {
                        extractDefinitionFromJson(response)
                    }catch (exception : Exception){
                        exception.printStackTrace()
                    }
                     */
                },
                {
                    error ->
                    error
                    //Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )
            queue.add(stringRequest)
        }

    }

    private fun getUrl() : String{
        val word = binding.textSearch.text
        val apiKey = "3fc755a7-3c6d-48ad-8faa-e7e22e433479"
        val url = //"https://content.guardianapis.com/search?api-key=3fc755a7-3c6d-48ad-8faa-e7e22e433479"
            "https://content.guardianapis.com/$word?api-key=$apiKey"

        return url
    }
}