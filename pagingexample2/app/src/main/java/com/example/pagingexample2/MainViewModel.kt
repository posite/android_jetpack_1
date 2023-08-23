package com.example.pagingexample2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pagingexample2.data.GithubDataModelItem
import com.example.pagingexample2.network.GithubApi
import com.example.pagingexample2.network.RetrofitInstance
import com.example.pagingexample2.paging.NamePagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    private val api = RetrofitInstance.getInstance().create(GithubApi::class.java)

    val items: Flow<PagingData<GithubDataModelItem>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            NamePagingSource(api)
        }
    ).flow
        .cachedIn(viewModelScope)
}