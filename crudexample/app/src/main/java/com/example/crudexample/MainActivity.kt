package com.example.crudexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudexample.databinding.ActivityMainBinding
import com.example.crudexample.db.entity.RandomNumberEntity
import com.example.crudexample.view.MainViewModel
import com.example.crudexample.view.NumberAdapter

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    lateinit var numberList: ArrayList<RandomNumberEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.createBtn.setOnClickListener {
            val randomNumber = (0..100).random()
            val numberEntity = RandomNumberEntity(0, randomNumber.toString())
            viewModel.create(numberEntity)
        }

        viewModel.read()
        viewModel.numberEntityList.observe(this, Observer {
            numberList = it as ArrayList<RandomNumberEntity>
            val adapter = NumberAdapter()
            adapter.submitList(numberList)
            binding.numberList.adapter = adapter
            binding.numberList.layoutManager = LinearLayoutManager(this)
            onClickEventHandler(adapter)
        })
    }

    private fun onClickEventHandler(adapter: NumberAdapter) {

        adapter.updateClicked = object : NumberAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberList[position])
            }

        }

        adapter.deleteClicked = object : NumberAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, "${numberList[position].number} 삭제됨", Toast.LENGTH_SHORT).show()
                viewModel.delete(numberList[position])
            }

        }

    }
}