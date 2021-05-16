package com.wolfgang.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.wolfgang.newsapp.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var pageNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        super.onCreate(savedInstanceState)
        setContentView(view)

        val queue = Volley.newRequestQueue(this)
        binding.buttonSearch.setOnClickListener {
            sendRequest()
        }

        binding.buttonMore.setOnClickListener {
            pageNumber += 1
            sendRequest()
        }

    }

    private fun getUrl(): String {
        val word = binding.textSearch.text
        val apiKey = "3fc755a7-3c6d-48ad-8faa-e7e22e433479"
        val url =
            //"https://content.guardianapis.com/search?page=1&page-size=10&q=football&api-key=3fc755a7-3c6d-48ad-8faa-e7e22e433479"
            "https://content.guardianapis.com/search?page=$pageNumber&page-size=10&q=$word&api-key=$apiKey"

        return url
    }

    private fun extractDefinitionFromJson(response: String) {
        val jsonResponseBody = JSONObject(response).getJSONObject("response")
        val results = jsonResponseBody.getJSONArray("results")

        var list = mutableListOf<Data>()

        for (i in 0..9) {
            val item = results.getJSONObject(i)
            val webTitle = item.getString("webTitle")
            val webUrl = item.getString("webUrl")
            val data = Data(webTitle, webUrl)
            list.add(data)

        }

        val customAdapter: CustomAdapter = CustomAdapter(list)
        binding.listView.adapter = customAdapter
    }

    private fun sendRequest() {

        val url = getUrl()
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                try {
                    extractDefinitionFromJson(response)
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            },
            { error ->
                Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
            })

        queue.add(stringRequest)
    }
}