package com.example.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newData : Data = workDataOf(
            "a" to 100,
            "b" to 200
        )
        val workerManager = OneTimeWorkRequestBuilder<MyWorkManager>().build()
        val secondWorkManager = OneTimeWorkRequestBuilder<SecondWorkManager>().setInputData(newData).build()
        val lastWorkManager = OneTimeWorkRequestBuilder<LastWorkManager>().build()

//        WorkManager.getInstance(this).enqueue(workerManager)
//        WorkManager.getInstance(this).enqueue(secondWorkManager)
//        WorkManager.getInstance(this).enqueue(lastWorkManager)
        WorkManager.getInstance(this)
            .beginWith(listOf(workerManager, secondWorkManager))
            .then(lastWorkManager)
            .enqueue()

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(secondWorkManager.id)
            .observe(this, Observer {
                if(it != null && it.state.isFinished) {
                    val result = it.outputData.getInt("result", 0)
                    Log.d("result", "result = $result")
                }
            })
    }
}