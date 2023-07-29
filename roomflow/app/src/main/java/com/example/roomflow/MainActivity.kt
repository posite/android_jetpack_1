package com.example.roomflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomflow.databinding.ActivityMainBinding
import com.example.roomflow.db.TextDB
import com.example.roomflow.db.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDB.getDatabase(this)

        binding.insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dao().insertData(TextEntity(0, binding.inputData.text.toString()))
                binding.inputData.setText("")
            }
        }

//        binding.getData.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                val data = db.dao().getAllData()
//                withContext(Dispatchers.Main) {
//                    binding.result.text = data.toString()
//                }
//            }
//        }
        CoroutineScope(Dispatchers.IO).launch {
            db.dao().getAllDataFlow().collect{
                val data = it.toString()
                withContext(Dispatchers.Main) {
                    binding.result.text = data.toString()
                }
            }

        }

        binding.deleteData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.dao().deleteData()
            }
        }

    }
}