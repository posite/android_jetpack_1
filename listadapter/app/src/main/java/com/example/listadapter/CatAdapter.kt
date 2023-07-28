package com.example.listadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CatAdapter : ListAdapter<CatModel, CatAdapter.CatViewHolder>(DiffCallBack){

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<CatModel>() {
            override fun areItemsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {

                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: CatModel, newItem: CatModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class CatViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val catId = view.findViewById<TextView>(R.id.catId)
        val catName = view.findViewById<TextView>(R.id.catName)
        val catAge = view.findViewById<TextView>(R.id.catAge)

        fun bind(data: CatModel) {
            catId.text = data.catId.toString()
            catName.text = data.catName.toString()
            catAge.text = data.catAge.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}