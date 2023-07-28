package com.example.bindingadapter

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("progress")
fun progressSetting(view: ImageView, pointType: PointType) {
    when(pointType) {
        PointType.Big -> {view.setColorFilter(Color.parseColor("#44ff66"))}
        PointType.MIDDLE -> {view.setColorFilter(Color.parseColor("#4466ff"))}
        PointType.SMALL -> {view.setColorFilter(Color.parseColor("#ff4466"))}
        else ->{view.setColorFilter(Color.parseColor("#cccccc"))}
    }
}