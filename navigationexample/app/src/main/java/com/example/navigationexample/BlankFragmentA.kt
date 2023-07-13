package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class BlankFragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bundle = Bundle()
        bundle.putString("key", "value")

        val action = BlankFragmentADirections.actionBlankFragmentAToBlankFragmentB("make")

        val views = inflater.inflate(R.layout.fragment_blank_a, container, false)
        views.findViewById<Button>(R.id.btn1).setOnClickListener {
//            Navigation.findNavController(views).navigate(R.id.action_blankFragmentA_to_blankFragmentB, bundle)
            Navigation.findNavController(views).navigate(action)
        }
        return views
    }


}