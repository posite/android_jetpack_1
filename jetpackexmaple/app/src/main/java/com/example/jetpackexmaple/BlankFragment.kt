package com.example.jetpackexmaple

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.jetpackexmaple.databinding.FragmentBlankBinding

class BlankFragment(private val text: String) : Fragment() {
    private var binding: FragmentBlankBinding? = null
    private val viewModel: MainViewModel by activityViewModels()
    private var number = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.data?.text = text
        binding?.data?.setOnClickListener {
            viewModel.clickWord()
        }
        viewModel.mapLiveData.observe(viewLifecycleOwner, Observer {
            binding?.data?.text = it
        })
//        viewModel.wordData.observe(viewLifecycleOwner, Observer {
//            binding?.data?.text = it
//        })
    }


}