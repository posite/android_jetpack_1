package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.catRv)
        val adapter = CatAdapter()
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(arrayListOf(CatModel(1,"cat1", 10),CatModel(2,"cat2", 3),
            CatModel(3,"cat3", 7)))

        Handler(Looper.getMainLooper()).postDelayed({adapter.submitList(arrayListOf(CatModel(3,"cat3", 7),CatModel(4,
            "cat4", 5), CatModel(5,"cat5", 4)))}, 2000)
    }
}