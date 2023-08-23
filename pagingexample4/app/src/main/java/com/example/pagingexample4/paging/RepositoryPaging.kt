package com.example.pagingexample4.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingexample4.data.Items
import com.example.pagingexample4.network.GithubApi
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class RepositoryPaging (private val githubService: GithubApi, private val query: String) :
    PagingSource<Int, Items>() {
    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        val anchorPosition = state.anchorPosition

        return anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        delay(1000)
        return try{
            val page = params.key ?: STARTING_KEY
            val queryMap = mutableMapOf<String, String>()
            queryMap["q"]=query
            queryMap["page"]=page.toString()
            queryMap["per_page"]=params.loadSize.toString()
            val response = githubService.getRepositories(queryMap)
            val datas = response.items

            return if(datas != null) {
                LoadResult.Page(
                    data = datas,
                    prevKey = if(page == 1) null else page-1,
                    nextKey = page + (params.loadSize/20)
                )
            } else {
                LoadResult.Page(
                    data = listOf(),
                    prevKey = null,
                    nextKey = page + (params.loadSize/20)
                )
            }
        } catch (exception: Exception) {
//            throw Exception(exception)
            LoadResult.Error(exception)
        }
    }


}