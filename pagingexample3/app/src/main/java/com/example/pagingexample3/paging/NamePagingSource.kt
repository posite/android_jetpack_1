package com.example.pagingexample3.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingexample3.data.GithubDataModelItem
import com.example.pagingexample3.network.GithubApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class NamePagingSource(private val githubService: GithubApi) :PagingSource<Int, GithubDataModelItem>() {
    override fun getRefreshKey(state: PagingState<Int, GithubDataModelItem>): Int? {
        val anchorPosition = state.anchorPosition

        return anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubDataModelItem> {
        val page = params.key ?: STARTING_KEY

        try{
            val response = githubService.getDatas(page, params.loadSize)
            val datas = response.body()

            if(page != 1) {
                delay(2000)
            }
            return if(datas != null) {
                LoadResult.Page(
                    data = datas,
                    prevKey = if(page == 1) null else page-1,
                    nextKey = page + (params.loadSize/30)
                )
            } else {
                LoadResult.Page(
                    data = listOf(),
                    prevKey = null,
                    nextKey = page + (params.loadSize/30)
                )
            }
        } catch (e: Exception) {
            Log.d("error", "error: ${e.message}")
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = page + (params.loadSize/30)
            )
        }
    }


}