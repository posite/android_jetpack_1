package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class TestWorkManager (context: Context, workP: WorkerParameters): CoroutineWorker(context, workP) {
    companion object {
        const val HowMuch = "progress"
    }

    override suspend fun doWork(): Result {

        for (i in 0..10) {
            val result = workDataOf(HowMuch to i*10)
            setProgress(result)
            delay(1000)
        }


        return Result.success()
    }
}