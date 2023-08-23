package com.example.pagingexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingexample3.paging.NameAdapter
import com.example.pagingexample3.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        lifecycleScope.launch {
            adapter.loadStateFlow.collect{
                val isLoadingNext = it.source.append is LoadState.Loading
                binding.loadingNext.isVisible = isLoadingNext

                val isLoadingPrev = it.source.prepend is LoadState.Loading
                binding.loadingPrev.isVisible = isLoadingPrev
            }
        }

        binding.refresh.setOnClickListener {
            adapter.refresh()
        }

    }
}