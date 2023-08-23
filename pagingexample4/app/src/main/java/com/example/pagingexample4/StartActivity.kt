package com.example.pagingexample4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pagingexample4.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("text", binding.inputArea.text.toString())
            startActivity(intent)

        }
    }
}