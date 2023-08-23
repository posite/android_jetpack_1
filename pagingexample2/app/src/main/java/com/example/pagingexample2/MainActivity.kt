package com.example.pagingexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingexample2.paging.NameAdapter
import com.example.pagingexample2.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            viewModel = ViewModelProvider(this)[MainViewModel::class.java]

            val adapter = NameAdapter()
            binding.githubDataList.adapter = adapter
            binding.githubDataList.layoutManager = LinearLayoutManager(this)

            lifecycleScope.launch {
                viewModel.items.collect{
                    adapter.submitData(it)
                }
            }
        } catch (e: Exception) {
            Log.d("error", "error: ${e.message}")
        }

    }
}