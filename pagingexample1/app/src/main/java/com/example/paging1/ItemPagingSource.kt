package com.example.paging1

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class ItemPagingSource: PagingSource<Int, ItemModel>() {

    init{
        Log.d("paging", "paging 시작")
    }
    //새로고침 시 동작
    override fun getRefreshKey(state: PagingState<Int, ItemModel>): Int? {
        return null
    }

    //페이지 실행시 동작
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemModel> {
        val page = params.key ?: STARTING_KEY

        val range = page.until(page + params.loadSize)

        if(page != STARTING_KEY) {
            delay(3000)
        }

        return LoadResult.Page(
            data = range.map { number->
                ItemModel(
                    id = number.toLong(),
                    content = "content = $number"
                )
            },
            prevKey = null,
            nextKey = range.last + 1
        )
    }

}