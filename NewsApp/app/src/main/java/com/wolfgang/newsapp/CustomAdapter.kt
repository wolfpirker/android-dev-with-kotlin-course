package com.wolfgang.newsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(var newsList: MutableList<Data>) : BaseAdapter() {
    override fun getCount() = newsList.size

    override fun getItem(position: Int) = newsList[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val context = parent?.context
        var rowView: View? = convertView

        val inflater: LayoutInflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (rowView == null)
            rowView = inflater.inflate(R.layout.item_list, parent, false)

        val item = newsList[position]

        val title = rowView?.findViewById<TextView>(R.id.title_text_view)
        title?.text = item.webTitle

        title?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.webUrl))
            context.startActivity(intent)
        }

        return rowView!!
    }
}