package com.example.pagingexample4.network

import com.example.pagingexample4.data.GithubSearchResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GithubApi {
    @GET("search/repositories")
    suspend fun getRepositories(@QueryMap query: Map<String, String>): GithubSearchResponse
}