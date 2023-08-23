package com.example.pagingexample4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingexample4.data.Items
import com.example.pagingexample4.network.GithubApi
import com.example.pagingexample4.network.RetrofitInstance
import com.example.pagingexample4.paging.RepositoryPaging
import kotlinx.coroutines.flow.Flow

class MainViewModel(val query: String): ViewModel() {

    private val api = RetrofitInstance.getInstance().create(GithubApi::class.java)

    val items: Flow<PagingData<Items>> = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = {
            RepositoryPaging(api, query)
        }
    ).flow
        .cachedIn(viewModelScope)
}