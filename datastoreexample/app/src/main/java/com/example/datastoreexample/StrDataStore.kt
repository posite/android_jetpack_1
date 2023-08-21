package com.example.datastoreexample

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StrDataStore(context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "str_pref")
    private val dataStore: DataStore<Preferences> = context.dataStore

    private val STR_KEY = stringPreferencesKey("STR_KEY")

    suspend fun insertStr(str: String) {
        dataStore.edit {
            it[STR_KEY] = str
        }
    }

    val getStr: Flow<String> = dataStore.data.map {
        val str = it[STR_KEY] ?: "default str"
        str
    }
}