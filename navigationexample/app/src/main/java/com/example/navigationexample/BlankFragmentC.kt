package com.example.navigationexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation


class BlankFragmentC : Fragment() {

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        val callback: OnBackPressedCallback = object: OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                Log.d("back", "back pressed")
//                view?.let {
//                    Navigation.findNavController(it).navigate(R.id.action_blankFragmentC_to_blankFragmentA)
//                }
//            }
//
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(callback)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val views = inflater.inflate(R.layout.fragment_blank_c, container, false)
//        views.findViewById<Button>(R.id.btn3).setOnClickListener {
//            Navigation.findNavController(views).navigate(R.id.action_blankFragmentC_to_blankFragmentA)
//        }
        return views
    }


}