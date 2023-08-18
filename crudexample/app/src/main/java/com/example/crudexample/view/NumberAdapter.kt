package com.example.crudexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.crudexample.databinding.RandomNumberListBinding
import com.example.crudexample.db.entity.RandomNumberEntity

class NumberAdapter: ListAdapter<RandomNumberEntity, NumberAdapter.ViewHolder>(DiffCallBack) {
    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<RandomNumberEntity>() {
            override fun areItemsTheSame(oldItem: RandomNumberEntity, newItem: RandomNumberEntity): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RandomNumberEntity, newItem: RandomNumberEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var updateClicked: ItemClick? = null
    var deleteClicked: ItemClick? = null

    inner class ViewHolder(private val binding: RandomNumberListBinding) : RecyclerView.ViewHolder(binding.root) {
        val update = binding.updateNumber
        val delete = binding.deleteNumber

        fun bind(datas: RandomNumberEntity) {
            binding.numberOrder.text = datas.id.toString()
            binding.randomNumber.text = datas.number

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        val binding = RandomNumberListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        holder.update.setOnClickListener {
            updateClicked?.onClick(it, position)
        }
        holder.delete.setOnClickListener {
            deleteClicked?.onClick(it, position)
        }
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

}