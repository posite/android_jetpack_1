package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CoroutineWork(context: Context, workP: WorkerParameters): CoroutineWorker(context, workP) {
    override suspend fun doWork(): Result {

        withContext(Dispatchers.IO) {
            test1()
            test2()
        }

        return Result.success()
    }

    suspend fun test1() {
        for(i in 1..10) {
            delay(1000)
            Log.d("test1", i.toString())
        }
    }

    suspend fun test2() {
        for(i in 1..10) {
            delay(1000)
            Log.d("test2", i.toString())
        }
    }
}