package com.example.pagingexample4.paging

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingexample4.data.Items
import com.example.pagingexample4.databinding.RepositoryListBinding

class RepositoryAdapter : PagingDataAdapter<Items, RepositoryAdapter.RepositoryViewHolder>(DiffCallBack) {

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<Items>() {
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = RepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    inner class RepositoryViewHolder(private val binding: RepositoryListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(datas: Items){
            binding.repoName.text = datas.name
            binding.repoUrl.text = datas.html_url
            binding.repoUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(datas.html_url))
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}