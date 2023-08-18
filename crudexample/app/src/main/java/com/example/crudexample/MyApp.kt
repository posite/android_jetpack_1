package com.example.crudexample

import android.app.Application
import android.content.Context

class MyApp: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: MyApp? = null

        fun context(): Context {
            return instance!!.applicationContext
        }
    }
}