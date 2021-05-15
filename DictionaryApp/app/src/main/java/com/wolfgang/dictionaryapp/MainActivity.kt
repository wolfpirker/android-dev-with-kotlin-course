package com.wolfgang.dictionaryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.wolfgang.dictionaryapp.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // API, Key (Learners)
    // 2c915c85-1a95-4247-b97a-21437a92a82d

    // JSON Request
    // https://www.dictionaryapi.com/api/v3/references/learners/json/
    // apple?key=2c915c85-1a95-4247-b97a-21437a92a82d

    private val KEY = "WORD_DEFINITION" // -> contanst in upper case!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val queue = Volley.newRequestQueue(this)
        binding.findButton.setOnClickListener {
            val word = binding.wordEditText.text
            val apiKey = "2c915c85-1a95-4247-b97a-21437a92a82d"
            val url = getUrl()
            val stringRequest = StringRequest(Request.Method.GET, url,
                {response ->
                    try {
                        extractDefinitionFromJson(response)
                    }catch (exception : Exception){
                        exception.printStackTrace()
                    }
                },
                {error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                }
            )
            queue.add(stringRequest)
        }

    }

    private fun getUrl() : String{
        val word = binding.wordEditText.text
        val apiKey = "2c915c85-1a95-4247-b97a-21437a92a82d"
        val url =
            "https://www.dictionaryapi.com/api/v3/references/learners/json/$word?key=$apiKey"

        return url
    }

    private fun extractDefinitionFromJson(response : String){

        val jsonArray = JSONArray(response)
        val firstIndex = jsonArray.getJSONObject(0) // first index of that array
        val getShortDefinition = firstIndex.getJSONArray("shortdef")
        val firstShortDefinition = getShortDefinition.get(0) // first index

        // to navigate from the one activity to the other one; we navigate to WordDefinitionActivity
        val intent = Intent(this, WordDefinitionActivity::class.java)
        intent.putExtra(KEY, firstShortDefinition.toString()) // pass the information to the new activity
        startActivity(intent)
    }

}