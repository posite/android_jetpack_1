package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class BlankFragmentC : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_blank_c, container, false)
        views.findViewById<Button>(R.id.btn3).setOnClickListener {
            Navigation.findNavController(views).navigate(R.id.action_blankFragmentC_to_blankFragmentA)
        }
        return views
    }
}