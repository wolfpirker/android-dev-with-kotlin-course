package com.wolfgang.numberlistapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class CustomAdapter(var arrayList: ArrayList<Data>) : BaseAdapter() {
    override fun getCount() = arrayList.size

    override fun getItem(position: Int) = arrayList[position]


    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val context = parent?.context
        val inflater: LayoutInflater =
            context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val rowView = inflater.inflate(R.layout.item_list, parent, false)

        val item = arrayList[position]

        val numberTextView = rowView.findViewById<TextView>(R.id.number_text_view)
        numberTextView.text = item.number

        return rowView
    }
}