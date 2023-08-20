package com.example.myapplication.db.entity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.util.*

@Entity(tableName = "text_table")
data class TextEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "text")
    val text: String,
//    @ColumnInfo(name = "currentDate")
//    val currentDate: Date
    @ColumnInfo(name = "photo")
    val photo: Bitmap
)

class DateConverter {

    @TypeConverter
    fun fromTimeToDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToTime(date: Date): Long {
        return date.time
    }

}

class BitmapConverter {
    @TypeConverter
    fun fromBitmapToByteArray(bitmap: Bitmap): ByteArray {
        val outputSteam = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputSteam)
        return outputSteam.toByteArray()
    }

    @TypeConverter
    fun fromByteArrayToBitmap(bArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bArray, 0, bArray.size)
    }

}