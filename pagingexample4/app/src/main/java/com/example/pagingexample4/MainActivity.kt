package com.example.pagingexample4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingexample4.databinding.ActivityMainBinding
import com.example.pagingexample4.paging.RepositoryAdapter
import com.example.pagingexample4.state.GithubLoadStateAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var adapter: RepositoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RepositoryAdapter()
        var text = intent.getStringExtra("text")
        Log.d("text", "text: $text")
        text?.let {
            loadData(it)
        }

    }

    fun loadData(query: String) {
        viewModelFactory = MainViewModelFactory(query)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.repoDataList.layoutManager = LinearLayoutManager(this)
//        binding.repoDataList.adapter = adapter
        binding.repoDataList.adapter = adapter.withLoadStateFooter(
            GithubLoadStateAdapter{
                adapter.retry()
            }
        )
        lifecycleScope.launch {
            viewModel.items.collect{
                adapter.submitData(it)
            }
        }
    }
}