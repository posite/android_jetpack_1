package com.example.roomflowlistadapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomflowlistadapter.databinding.ActivityUdactivityBinding
import com.example.roomflowlistadapter.db.UserDB
import com.example.roomflowlistadapter.db.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UDActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUdactivityBinding
    private var search = mutableListOf<UserEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUdactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDB.getDB(this)
        val userListAdapter = UserListAdapter()

        binding.userList.adapter = userListAdapter
        binding.userList.layoutManager = LinearLayoutManager(this)

        binding.read.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDAO().getAllUserFlow().collect() {
                    withContext(Dispatchers.Main) {
                        userListAdapter.submitList(it)
                    }
                }
            }
        }

        binding.update.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDAO().getAllUser()
                val userEntity = result[id]
                userEntity.age = 0
                userEntity.name = "new"
                db.userDAO().updateUser(userEntity)
            }
        }

        binding.delete.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDAO().getAllUser()
                val userEntity = result[id]
                userEntity.age = 0
                userEntity.name = "new"
                db.userDAO().deleteUser(userEntity)
            }
        }
    }
}