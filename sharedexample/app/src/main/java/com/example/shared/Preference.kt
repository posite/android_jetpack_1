package com.example.shared

import android.content.Context
import android.content.SharedPreferences

class Preference (context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("id", Context.MODE_PRIVATE)

    fun getStr(key: String): String {
        return prefs.getString(key, "default str")!!
    }
    fun setStr(key: String, address: String) {
        prefs.edit().putString(key, address).apply()
    }

    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)!!
    }

    fun setBoolean(key: String, value: Boolean) {
        prefs.edit().putBoolean(key, value).apply()
    }

}