package com.example.navigationexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


class BlankFragmentB : Fragment() {
    val args: BlankFragmentBArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val getString = arguments?.getString("key")
//        Log.d("bundle value", getString.toString())
        val views = inflater.inflate(R.layout.fragment_blank_b, container, false)
        views.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(views).navigate(R.id.action_blankFragmentB_to_blankFragmentC)
        }
        Log.d("key", "value: ${args.key}")
        return views
    }
}