package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class LastWorkManager(context: Context, workP: WorkerParameters): Worker(context, workP) {
    override fun doWork(): Result {
        for(i in 1..10) {
            Thread.sleep(1000)
            Log.d("LastWorkManager", i.toString())
        }
        return Result.success()
    }
}