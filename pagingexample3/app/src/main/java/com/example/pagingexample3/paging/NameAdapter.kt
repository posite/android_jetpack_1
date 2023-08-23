package com.example.pagingexample3.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingexample3.data.GithubDataModelItem
import com.example.pagingexample3.databinding.NameListBinding

class NameAdapter: PagingDataAdapter<GithubDataModelItem, NameAdapter.NameViewHolder>(DiffCallBack) {

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<GithubDataModelItem>() {
            override fun areItemsTheSame(oldItem: GithubDataModelItem, newItem: GithubDataModelItem): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GithubDataModelItem, newItem: GithubDataModelItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val binding = NameListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NameViewHolder(binding)
    }

    inner class NameViewHolder(private val binding: NameListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(datas: GithubDataModelItem){
            binding.itemName.text = datas.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}