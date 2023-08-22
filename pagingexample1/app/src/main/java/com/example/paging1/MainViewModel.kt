package com.example.paging1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import kotlinx.coroutines.flow.Flow

class MainViewModel : ViewModel() {
    //cachedInt - 페이징을 vimodelscope에 포함시켜서 화면이 재시작되도 다시 시작하지 않고 유지될 수 있음   특히 화면 회전등
    val items: Flow<PagingData<ItemModel>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            ItemPagingSource()
        }
    ).flow
        .cachedIn(viewModelScope)

}