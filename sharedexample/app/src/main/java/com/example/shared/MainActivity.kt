package com.example.shared

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.shared.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val preferences = Preference(this)
        val keyAliases = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val sharedPreferences = EncryptedSharedPreferences.create(
            "shared_file_name",
            keyAliases,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )


        binding.saveBtn.setOnClickListener {
//            preferences.setStr(KeyList.STR_KEY, binding.inputArea.text.toString())
            sharedPreferences.edit().putString(KeyList.STR_KEY, binding.inputArea.text.toString()).apply()
        }
        binding.loadBtn.setOnClickListener {
//            val text = preferences.getStr(KeyList.STR_KEY)
//            Log.d("text", "text: $text")
            val text = sharedPreferences.getString(KeyList.STR_KEY, "default str")
            Log.d("text", "text: $text")
        }

        binding.setTrueBtn.setOnClickListener {
//            preferences.setBoolean(KeyList.BOOLEAN_KEY, true)
        }
        binding.setFalseBtn.setOnClickListener {
//            preferences.setBoolean(KeyList.BOOLEAN_KEY, false)
        }
        binding.getBooleanBtn.setOnClickListener {
//            val boolean = preferences.getBoolean(KeyList.BOOLEAN_KEY)
//            Log.d("boolean", "boolean: $boolean")
        }
    }
}