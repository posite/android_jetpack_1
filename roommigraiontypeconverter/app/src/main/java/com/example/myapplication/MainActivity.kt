package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.drawable.toBitmap
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.db.TextDB
import com.example.myapplication.db.entity.TextEntity
import com.example.myapplication.db.entity.TextEntity2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDB.getDB(this)

        binding.insertBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDAO().insertText(TextEntity(0, binding.inputArea.text.toString(), getDrawable(R.drawable.bell)!!.toBitmap()))
//                db.textDAO2().insertText(TextEntity2(0, binding.inputArea.text.toString(), "new Text"))
                binding.inputArea.setText("")
            }
        }

        binding.getDataBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.textDAO().getAllText()
                Log.d("datas1", result.toString())
//                Log.d("datas2", db.textDAO2().getAllText().toString())
                withContext(Dispatchers.Main) {
                    binding.resultImg.setImageBitmap(result[0].photo)
                }
            }
        }

        binding.deleteBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDAO().deleteAllText()
//                db.textDAO2().deleteAllText()
            }
        }

    }
}