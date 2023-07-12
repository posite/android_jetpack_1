package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class SecondWorkManager (context: Context, workP: WorkerParameters): Worker(context, workP) {
    override fun doWork(): Result {
        val a = inputData.getInt("a", 1)
        val b = inputData.getInt("b", 2)

        Log.d("numbers", "a: $a  b: $b")

        val outPut: Data = workDataOf("result" to (a+b))
        return Result.success(outPut)
    }
}