package com.example.roomflowlistadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomflowlistadapter.databinding.ActivityMainBinding
import com.example.roomflowlistadapter.db.UserDB
import com.example.roomflowlistadapter.db.UserEntity
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

        val db = UserDB.getDB(this)
        val userListAdapter = UserListAdapter()

        binding.userList.adapter = userListAdapter
        binding.userList.layoutManager = LinearLayoutManager(this)

        binding.save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDAO().insertUser(UserEntity(0, binding.age.text.toString().toInt(), binding.name.text.toString()))
                binding.age.setText("")
                binding.name.setText("")
            }

        }

        binding.getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDAO().getAllUserFlow().collect(){
                    withContext(Dispatchers.Main) {
                        userListAdapter.submitList(it)
                    }
                }
            }
        }

        binding.next.setOnClickListener {
            val intent = Intent(this, UDActivity::class.java)
            startActivity(intent)
        }
    }
}