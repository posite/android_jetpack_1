package com.example.pagingexample3.network

import com.example.pagingexample3.data.GithubDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("users/google/repos")
    suspend fun getDatas(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Response<GithubDataModel>
}