package com.example.uniquework

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class TestWorkManager (context: Context, workP: WorkerParameters): CoroutineWorker(context, workP) {
    companion object {
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        Log.d("TestWorkManager", "start")
        for (i in 0..3) {
            Log.d("TestWorkManager", i.toString())
            delay(1000)
        }
        Log.d("TestWorkManager", "end")

        return Result.success()
    }
}