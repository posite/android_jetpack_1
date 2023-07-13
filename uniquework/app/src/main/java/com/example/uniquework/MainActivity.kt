package com.example.uniquework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.test_btn)
        btn.setOnClickListener {
            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
//            WorkManager.getInstance(this).enqueue(testWorkManager)
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)
        }
    }
}