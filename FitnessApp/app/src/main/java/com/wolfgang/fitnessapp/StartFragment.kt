package com.wolfgang.fitnessapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartFragment : Fragment() {

    lateinit var goButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_start, container, false)

        goButton = v.findViewById(R.id.button_go)

        goButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_exerciseFragment)
        )

        setHasOptionsMenu(true)

        return v
    }
}
