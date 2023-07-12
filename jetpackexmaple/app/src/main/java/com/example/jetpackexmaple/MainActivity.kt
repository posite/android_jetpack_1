package com.example.jetpackexmaple


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackexmaple.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.inputBtn.setOnClickListener {
            Log.d("inputs", "inputs: ${binding.inputWord.text}")
            viewModel.setWord(binding.inputWord.text.toString())
        }

        viewModel.wordData.observe(this, Observer {
            binding.resultText.text = it
            binding.inputWord.setText("")
        })
    }
}