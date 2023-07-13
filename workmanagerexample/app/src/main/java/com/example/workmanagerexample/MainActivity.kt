package com.example.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.workmanagerexample.TestWorkManager.Companion.HowMuch
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val newData : Data = workDataOf(
//            "a" to 100,
//            "b" to 200
//        )
//        val workerManager = OneTimeWorkRequestBuilder<MyWorkManager>().build()
//        val secondWorkManager = OneTimeWorkRequestBuilder<SecondWorkManager>().setInputData(newData).build()
//        val lastWorkManager = OneTimeWorkRequestBuilder<LastWorkManager>().build()

//        val coroutineM = OneTimeWorkRequestBuilder<CoroutineWork>().build()
//        WorkManager.getInstance(this).enqueue(coroutineM)
//        val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
//        WorkManager.getInstance(this).enqueue(testWorkManager)
//        WorkManager.getInstance(this)
//            .getWorkInfoByIdLiveData(testWorkManager.id)
//            .observe(this, Observer{it: WorkInfo?->
//                val progress = it?.progress
//                val value = progress?.getInt(HowMuch, 0)
//                if(value != 0) {
//                    Log.d("result", value.toString())
//                }
//                if(value == 100) {
//                    Log.d("result", "작업 종료")
//                }
//            })
        val workManager = PeriodicWorkRequestBuilder<MyWorkManager>(1, TimeUnit.SECONDS).build()
        WorkManager.getInstance(this).enqueue(workManager)
//        WorkManager.getInstance(this).enqueue(workerManager)
//        WorkManager.getInstance(this).enqueue(secondWorkManager)
//        WorkManager.getInstance(this).enqueue(lastWorkManager)
//        WorkManager.getInstance(this)
//            .beginWith(listOf(workerManager, secondWorkManager))
//            .then(lastWorkManager)
//            .enqueue()
//
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(secondWorkManager.id)
//            .observe(this, Observer {
//                if(it != null && it.state.isFinished) {
//                    val result = it.outputData.getInt("result", 0)
//                    Log.d("result", "result = $result")
//                }
//            })
    }
}