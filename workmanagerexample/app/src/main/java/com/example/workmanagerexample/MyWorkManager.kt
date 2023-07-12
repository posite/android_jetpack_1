package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class MyWorkManager(context: Context, workP: WorkerParameters): Worker(context, workP) {
    override fun doWork(): Result {
        for(i in 1..10) {
            sleep(1000)
            Log.d("workmanager", i.toString())
        }
        return Result.success()
    }
}